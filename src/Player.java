import java.util.ArrayList;

public class Player {
    // Josue Mayorga

    private static int currentLocation;
    private static int hp;
    private static int attack;
    private static boolean hasEquipedItem;
    private static String equipedItem;



    Map map = new Map();


    Player(int hp, int attack,boolean hasEquipedItem, String equipedItem) {
        this.hp = hp;
        this.attack = attack;
        this.hasEquipedItem = hasEquipedItem;
        this.equipedItem = equipedItem;
    }
    Player(){

    }

    /**
     * arrayList of Items
     * inventory
     */
    private static ArrayList<Items> inventory = new ArrayList<>();

    public static ArrayList<Items> getInventory(){
        return inventory;
    }
    /**
     * Method: playerStatus()
     * returns player states
     */
    protected void playerStatus()
    {
        System.out.println("Player Status");
        System.out.println("Hp: " + Player.getHp() + " Attack: " + Player.getAttack());}


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
