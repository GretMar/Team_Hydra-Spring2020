import java.util.ArrayList;

public class Items {
	private int currentIndex;
	
    private int itemId;
    private String itemName;
    private String itemDesc;
    private boolean equipped;
    private boolean isConsumable;
    private int attackBoost;
    private int hpBoost;


    public Items(int itemId, String itemName, String itemDesc, boolean equipped, boolean isConsumable, int attackBoost, int hpBoost) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.equipped = equipped;
        this.isConsumable = isConsumable;
        this.attackBoost = attackBoost;
        this.hpBoost = hpBoost;
    }


    public Items(){

    }

    /**
     * Method getItemId
     * @return itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Method setItemId
     * @param itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Method getITemName
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Method setItemName()
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Method getItemDesc
     * @return itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * Method setItemDesc
     * @param itemDesc
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public boolean isConsumable() {
        return isConsumable;
    }

    public void setConsumable(boolean consumable) {
        isConsumable = consumable;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    public int getHpBoost() {
        return hpBoost;
    }

    public void setHpBoost(int hpBoost) {
        this.hpBoost = hpBoost;
    }

    public static void equip(String item){
        for(int i = 0; i < Player.getInventory().size(); i++)
        {
            if(item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()) && !Player.getInventory().get(i).isConsumable)
            {
                if(Player.isHasEquipedItem())
                {
                    System.out.println("You already have an item equipped");
                }
                else
                {
                    Player.setAttack(Player.getAttack() + Player.getInventory().get(i).getAttackBoost());

                    Player.getInventory().get(i).setEquipped(true);
                    Player.setHasEquipedItem(true);
                    Player.setEquipedItem(Player.getInventory().get(i).getItemName());
                    System.out.println("You have equipped the " + Player.getInventory().get(i).getItemName());
                }
            }
            else if(item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()) && Player.getInventory().get(i).isConsumable)
            {
                System.out.println("Cannot equip Consumable Item!");
            }
        }
    }

    public static void unEquip(String item){
        for(int i = 0; i < Player.getInventory().size(); i++)
        {
            if(item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()) && !Player.getInventory().get(i).isConsumable)
            {
                if(Player.isHasEquipedItem())
                {
                    Player.setAttack(Player.getAttack() - Player.getInventory().get(i).getAttackBoost());
                    Player.getInventory().get(i).setEquipped(false);
                    Player.setHasEquipedItem(false);
                    Player.setEquipedItem("None");
                    System.out.println("You have Unequipped the " + Player.getInventory().get(i).getItemName());

                }
                else
                {
                    System.out.println("You don't have anything equipped");
                }
            }
            else if(item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()) && Player.getInventory().get(i).isConsumable)
            {
                System.out.println("Cannot Unequipped Consumable Item!");
            }
        }
    }

    public static void heal(String item)
    {
        for(int i = 0; i < Player.getInventory().size();i++)
        {
            if(item.equalsIgnoreCase(Player.getInventory().get(i).getItemName()) && Player.getInventory().get(i).isConsumable)
            {
                Player.setHp(Player.getHp() + Player.getInventory().get(i).getHpBoost());
                System.out.println("You used a " + Player.getInventory().get(i).getItemName());
                Player.getInventory().remove(i);
            }
        }

    }

    /*
    public void removeItem(Items item) {
		currentIndex = Items.indexOf(item);
		inventory.remove(currentIndex);
	}*/
}
