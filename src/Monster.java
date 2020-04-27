import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Monster {
    private int mId;
    private String mName;
    private String mDescription;
    private int location;
    private int mHp;
    private String attack1Des;
    private int attack1damage;
    private String attack2Des;
    private int attack2damage;
    private String attack3Des;
    private int attack3damage;
    private String attack4Des;
    private int attack4damage;

    public Monster(int mId, String mName, String mDescription, int location, int mHp, String attack1Des, int attack1damage, String attack2Des,
                   int attack2damage, String attack3Des, int attack3damage, String attack4Des, int attack4damage) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.location = location;
        this.mHp = mHp;
        this.attack1Des = attack1Des;
        this.attack1damage = attack1damage;
        this.attack2Des = attack2Des;
        this.attack2damage = attack2damage;
        this.attack3Des = attack3Des;
        this.attack3damage = attack3damage;
        this.attack4Des = attack4Des;
        this.attack4damage = attack4damage;
    }


    public void fightMonster() throws IOException {
        //System.out.println(Player.getPlayer().get(0).getHp());
        Scanner fInput = new Scanner(System.in);
        for(int i = 0; i < Map.getMonsters().size(); i++ ) {
            //System.out.println(player.getHp());
            while (mHp > 0 && Player.getHp() > 0) {
                System.out.println(mName);
                // System.out.println(mDescription);
                System.out.println("Monster Hp: " + mHp + " Attack: ");
                System.out.println("Player Hp: " + Player.getHp() + " Attack: " + Player.getAttack());
                System.out.println("What will you do (enter number): ");

                System.out.println("1.Attack \n2.Use health item \n3.Equip Item");
                String chose1 = fInput.nextLine();
                if (chose1.equalsIgnoreCase("1")) {
                    int max = 4;
                    int min = 1;
                    int range = max - min + 1;
                    int monsterNumber = (int) (Math.random() * range) + min;
                    mHp = mHp - Player.getAttack();
                    if (monsterNumber == 1) {
                        System.out.println(getAttack1Des());
                        Player.setHp(Player.getHp() - (getAttack1damage()));
                    }
                    else if (monsterNumber == 2) {
                        System.out.println(getAttack2Des());
                        Player.setHp(Player.getHp() - (getAttack2damage()));
                    }
                    else if (monsterNumber == 3) {
                        System.out.println(getAttack3Des());
                        Player.setHp(Player.getHp() - (getAttack3damage()));
                    }
                    else if (monsterNumber == 4) {
                        System.out.println(getAttack4Des());
                        Player.setHp(Player.getHp() - (getAttack4damage()));
                    }

                } else if (chose1.equalsIgnoreCase("2")) {

                    Player.printInventory();
                    System.out.println("What item do you want to heal with: ");
                    String h = fInput.nextLine();
                    Items.heal(h);

                } else if (chose1.equalsIgnoreCase("3")) {
                    Scanner equipInput = new Scanner(System.in);
                    System.out.println("1.Equip\n2.Unequipped");
                    int p = fInput.nextInt();
                    if (p == 1) {
                        Player.printInventory();
                        System.out.println("What item do you want to Equip: ");
                        String h = equipInput.nextLine();
                        Items.equip(h);
                    }
                    else if(p == 2)
                    {
                        Player.printInventory();
                        System.out.println("What item do you want to UnEquip: ");
                        String h = equipInput.nextLine();
                        Items.unEquip(h);
                    }

                }
                else if(chose1.equalsIgnoreCase("help"))
                {
                    Player.fightHelp();
                }
                else {
                    System.out.println("Invalid try Again!");
                    fightMonster();
                }

            }
            if (mHp <= 0) {
                System.out.println("You defeated the " + mName + "!!");
                for(int j = 0; j < Map.getMonsters().size(); j++) {
                    Map.removeMonster(Map.getMonsters().get(j));
                    Map.getRooms().get(Player.getCurrentLocation()).setHasMonster(0);
                }
            }
            if(Player.getHp() <= 0)
            {
                Scanner lifeInput = new Scanner(System.in);

                System.out.println("Your hp is 0! You have Died!!!\n1.Start Over\\2.Quit");
                String ans = lifeInput.nextLine();
                if (ans.equalsIgnoreCase("1"))
                {
                    Game game = new Game();
                    game.play();

                }
                else if(ans.equalsIgnoreCase("2"))
                {
                    System.out.println("GAME OVER");
                    System.exit(0);
                }

            }

        }
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getmHp() {
        return mHp;
    }

    public void setmHp(int mHp) {
        this.mHp = mHp;
    }

    public String getAttack1Des() {
        return attack1Des;
    }

    public void setAttack1Des(String attack1Des) {
        this.attack1Des = attack1Des;
    }

    public int getAttack1damage() {
        return attack1damage;
    }

    public void setAttack1damage(int attack1damage) {
        this.attack1damage = attack1damage;
    }

    public String getAttack2Des() {
        return attack2Des;
    }

    public void setAttack2Des(String attack2Des) {
        this.attack2Des = attack2Des;
    }

    public int getAttack2damage() {
        return attack2damage;
    }

    public void setAttack2damage(int attack2damage) {
        this.attack2damage = attack2damage;
    }

    public String getAttack3Des() {
        return attack3Des;
    }

    public void setAttack3Des(String attack3Des) {
        this.attack3Des = attack3Des;
    }

    public int getAttack3damage() {
        return attack3damage;
    }

    public void setAttack3damage(int attack3damage) {
        this.attack3damage = attack3damage;
    }

    public String getAttack4Des() {
        return attack4Des;
    }

    public void setAttack4Des(String attack4Des) {
        this.attack4Des = attack4Des;
    }

    public int getAttack4damage() {
        return attack4damage;
    }

    public void setAttack4damage(int attack4damage) {
        this.attack4damage = attack4damage;
    }
}
