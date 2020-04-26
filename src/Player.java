import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    // Josue Mayorga

    private static int currentLocation;
    private static int hp = 100;
    private static int attack = 20;
    private static boolean hasEquipedItem;
    private static String equipedItem;



    Map map = new Map();
    private static ArrayList<Player> player = new ArrayList<>();

    public static ArrayList<Player> getPlayer(){return player;}

    public static void addplayer(Player p){player.add(p);}

    Player(int hp, int attack,boolean hasEquipedItem, String equipedItem) {
        this.hp = hp;
        this.attack = attack;
        this.hasEquipedItem = hasEquipedItem;
        this.equipedItem = equipedItem;
    }
    Player(){

    }
    protected void playerStatus()
    {
        System.out.println("Player Status");
        System.out.println("Hp: " + Player.getHp() + " Attack: " + Player.getAttack());}

    /**
     * arrayList of Items
     * inventory
     */
    private static ArrayList<Items> inventory = new ArrayList<>();

    public static ArrayList<Items> getInventory(){
        return inventory;
    }

    /**
     * Method PrintInventory
     *
     */
    protected static void printInventory() {
        System.out.println("Current player inventory:");
        if (!inventory.isEmpty()) {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println("[" + inventory.get(i).getItemName() + "]");
            }
        }
        if (inventory.isEmpty())
        {
            System.out.println("Empty");
        }
    }
    /**
     * Method inspect
     * Checks if an Item, puzzle, monster are in the room
     * and displays it to the player
     */
    public void inspect()
    {
        if(Map.getRooms().get(currentLocation).getHasItem() == 1)
        {
            System.out.println("==================================================================");
            System.out.print("The items in the room are: ");
            for(int i = 0; i < map.getItems().size(); i++) {
                if(Map.getRooms().get(currentLocation).getRoomID() == map.getItems().get(i).getItemId())
                    System.out.print("[" +map.getItems().get(i).getItemName() + "] ");
            }
        }
        else if(Map.getRooms().get(currentLocation).getHasItem() == 0) {
            System.out.println("No items in the room");
        }
        if(Map.getRooms().get(currentLocation).getHasPuzzle() != 0)
        {
            System.out.println("The room has a puzzle");
            //if(()//getRoomID()+"").equals(map.getPuzzles().get(i).getPuzzleID()))//this def needs to be changed
            System.out.println("Puzzle name: " + Map.getRooms().get(currentLocation).getrPuzzle().getPuzzleName());

        }
        if(Map.getRooms().get(currentLocation).getHasMonster() == 1)
        {
            System.out.println("\nThere is a Monster in this room!!!");
            for(int i = 0; i < Map.getMonsters().size(); i++)
            {
                if(Map.getRooms().get(currentLocation).getRoomID() == Map.getMonsters().get(i).getLocation())
                {
                    System.out.println("Monster: " + Map.getMonsters().get(i).getmName());
                }
            }
        }

    }


    protected void pickup(String item) {
        int count = 0;
        for(int i =0; i < map.getItems().size(); i++) {
            if (item.equalsIgnoreCase(map.getItems().get(i).getItemName())) {
                inventory.add(map.getItems().get(i));
                map.getItems().remove(i);

                for(i = 0; i < inventory.size(); i++)
                {
                    if(item.equalsIgnoreCase(inventory.get(i).getItemName()))
                    {
                        System.out.println(inventory.get(i).getItemName() + " has " +
                                "been picked up and added to player inventory");
                    }
                    else
                    {
                        System.out.println("Invalid input try again");
                    }

                }
                for(i = 0;i< map.getItems().size(); i++)
                {
                    if(Map.getRooms().get(currentLocation).getHasItem()==1)
                    {
                        if(Map.getRooms().get(currentLocation).getRoomID()== map.getItems().get(i).getItemId())
                        {
                            count++;
                        }
                    }
                }
                if(count == 0)
                {
                    Map.getRooms().get(currentLocation).setHasItem(0);
                }
            }

        }
    }
    /**
     * Method drop()
     * @param item
     * removes item form player inventory
     * and adds it back to map room items
     */
    public void drop(String item)
    {
        int count = 0;
        for(int i = 0; i < inventory.size(); i++)
        {
            if(item.equalsIgnoreCase(inventory.get(i).getItemName()))
            {
                map.addItems(inventory.get(i));
                inventory.get(i).setItemId(Map.getRooms().get(currentLocation).getRoomID());
                inventory.remove(i);
                for(i = 0; i < map.getItems().size(); i++)
                {
                    if(item.equalsIgnoreCase(map.getItems().get(i).getItemName()))
                    {
                        System.out.println(map.getItems().get(i).getItemName() + " has been dropped from player inventory into " +
                                Map.getRooms().get(currentLocation).getRoomName());
                    }
                    if(Map.getRooms().get(currentLocation).getHasItem() == 0)
                    {
                        if(Map.getRooms().get(currentLocation).getRoomID() == map.getItems().get(i).getItemId())
                        {
                            count++;
                        }
                    }
                }
            }
        }
        if(count > 0)
        {
            map.getRooms().get(currentLocation).setHasItem(1);
        }
    }
    /**
     *Method Scout
     * @param answer
     * returns item description if item is in room
     * or in player inventory
     * Ask puzzle question
     * Begins fight if monster
     */
    Scanner input = new Scanner(System.in);
    public void scout(String answer) throws IOException {
        for(int i = 0; i < map.getItems().size(); i++)
        {
            if(answer.equalsIgnoreCase(map.getItems().get(i).getItemName()))
            {
                System.out.println(map.getItems().get(i).getItemDesc());
            }
        }
        for(int i = 0; i < inventory.size(); i++)
        {
            if(answer.equalsIgnoreCase(inventory.get(i).getItemName()))
            {
                System.out.println(inventory.get(i).getItemDesc());
            }
        }
        for(int i = 0; i < map.getPuzzles().size(); i++)
        {
            if(answer.equalsIgnoreCase(map.getPuzzles().get(i).getPuzzleName()))
            {
                System.out.println(map.getPuzzles().get(i).getPuzzleQuestion());
                String ans = input.nextLine();
                // map.solveThePuzzle(ans);

            }
        }
        for(int i = 0; i < Map.getMonsters().size(); i++)
        {
            if(answer.equalsIgnoreCase(Map.getMonsters().get(i).getmName()))
            {
                Scanner mInput = new Scanner(System.in);

                System.out.println(Map.getMonsters().get(i).getmDescription());
                System.out.println("Hp: " + Map.getMonsters().get(i).getmHp());
                // System.out.println("Attack: " + Map.getMonsters().get(i).getmAttack());
                System.out.println("===================================================");
                System.out.println("What do you want to do?(Enter Number");
                System.out.println("1. Fight");
                System.out.println("2. ignore");
                int chose = mInput.nextInt();
                if(chose == 1)
                {
                    Map.getMonsters().get(i).fightMonster();
                }
                else if(chose == 2)
                {
                    Map.removeMonster(Map.getMonsters().get(i));
                    Map.getRooms().get(getCurrentLocation()).setHasMonster(0);
                    System.out.println("Monster is gone.");
                }
            }
        }
    }

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        Player.hp = hp;
    }

    public static int getAttack() {
        return attack;
    }

    public static void setAttack(int attack) {
        Player.attack = attack;
    }

    public static boolean isHasEquipedItem() {
        return hasEquipedItem;
    }

    public static void setHasEquipedItem(boolean hasEquipedItem) {
        Player.hasEquipedItem = hasEquipedItem;
    }

    public static String getEquipedItem() {
        return equipedItem;
    }

    public static void setEquipedItem(String equipedItem) {
        Player.equipedItem = equipedItem;
    }

    public static int getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(int currentLocation) {
        Player.currentLocation = currentLocation;
    }
}
