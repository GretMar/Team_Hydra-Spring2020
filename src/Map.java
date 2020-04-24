import java.util.ArrayList;

public class Map {
    private static ArrayList<Room> rooms = new ArrayList<>();

    private static ArrayList<Monster> monsters = new ArrayList<>();


    /**
     * Method: getRooms()
     * @return rooms
     */
    public static ArrayList<Room> getRooms()
    {
        return rooms;
    }
    /**
     *Method addrooms()
     * adds to arrayList of rooms
     * @param r
     */
    public static void addrooms(Room r)
    {
        rooms.add(r);
    }
    public  void getRoom(int direction)
    {
        if(direction == 0 )
        {
            System.out.println("Sorry there's a wall there try again.");
        }
        else {

            if(rooms.get(direction - 1).getHasVisted())
            {
                System.out.println("You been here before");
            }
            if(direction == (rooms.get(direction - 1 ).getRoomID()))
            {
                Player.setCurrentLocation(direction - 1);
            }
        }
    }
    public static ArrayList<Monster> getMonsters(){
        return monsters;
    }
    public static void addMonster(Monster m){ monsters.add(m);}

    public static void removeMonster(Monster m){monsters.remove(m);}
}
