import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    //Making a change through AnasBranch on git
    //Reading in files added through JosueBranch

    /**
     * main Method where file is read
     *
     * @param
     */
    public void play() throws NullPointerException, FileNotFoundException {
        /**
         Scanner to take in your input
         */
        Scanner input = new Scanner(System.in);
        /**
         * create instance of Player
         */
        Player player = new Player();

        /**
         * open text file
         */
        File textFile = new File("rooms1.txt");

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(textFile);
            /**
             * reads nextline as long as there is one
             */
            while (fileReader.hasNextLine()) {
                int roomId = Integer.parseInt(fileReader.nextLine());
              //   System.out.println(roomId);

                String roomName = fileReader.nextLine();
               //  System.out.println(roomName);

                String temp = fileReader.nextLine();
                boolean hasV = Boolean.parseBoolean(temp);
               //  System.out.println(hasV);

                String roomDes = fileReader.nextLine();
               //  System.out.println(roomDes);
                int hasItem = Integer.parseInt(fileReader.nextLine());
               //  System.out.println(hasItem);

                int hasPuzzle = Integer.parseInt(fileReader.nextLine());
                // System.out.println(hasPuzzle);
                int hasMonster = Integer.parseInt(fileReader.nextLine());
                //System.out.println(hasMonster);

                int northR = Integer.parseInt(fileReader.nextLine());
                int eastR = Integer.parseInt(fileReader.nextLine());
                int southR = Integer.parseInt(fileReader.nextLine());
                int westR = Integer.parseInt(fileReader.nextLine());

                //System.out.println(northR + " " + eastR + " " + southR + " " + westR);


                Map.addrooms(new Room(roomId, roomName, hasV, roomDes, hasItem, hasPuzzle, hasMonster, northR, eastR, southR, westR));


            }
            /**
             * close roomReader
             */
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }
        /**
         * Instructions
         */
        System.out.println("============================================================================================");
        System.out.println("Instructions");
        System.out.println("Pick option by entering number next to it.");
        System.out.println("Move by entering a direction (example north or n)");
        System.out.println("End game at any time by entering 'Exit'");
        System.out.println("============================================================================================");
        System.out.println();
        /**
         * Start at index zero
         */
        int roomID = 0;
        boolean done = false;
        /**
         * Menu that takes user input and sets on the loop that
         * they choose
         */
        while (!done) {
            {
                System.out.println("============================================================================================");
                player.playerStatus();
                System.out.println("You are now in room " + Map.getRooms().get(roomID).getRoomID() + " " + Map.getRooms().get(roomID).getRoomName() + ": \n"
                        + Map.getRooms().get(roomID).getRoomDescrip());
                System.out.println();
                System.out.println("What would you like to do?(enter number)");
                System.out.println("1. Move \n2. Inspect Area \n3. Check inventory ");
                String userInput = input.nextLine();
                /**
                 * loop calls methods from Map and Player class
                 * takes user input and moves player to location if move is  valid
                 * returns room id, name , description of new room
                 */
                if (userInput.equalsIgnoreCase("1")) {
                    Scanner di = new Scanner(System.in);
                    player.playerStatus();
                    System.out.println("Which direction would you like to go: (N,E,S,W) ");
                    String direction = di.next();
                    System.out.println("============================================================================================");
                    if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("N")) {
                        int number = Map.getRooms().get(roomID).getNorth();
                        player.map.getRoom(number);

                    } else if (direction.equalsIgnoreCase("East") || direction.equalsIgnoreCase("E")) {
                        int number = Map.getRooms().get(roomID).getEast();
                        player.map.getRoom(number);

                    } else if (direction.equalsIgnoreCase("South") || direction.equalsIgnoreCase("S")) {
                        int number = Map.getRooms().get(roomID).getSouth();
                        player.map.getRoom(number);

                    } else if (direction.equalsIgnoreCase("West") || direction.equalsIgnoreCase("W")) {
                        int number = Map.getRooms().get(roomID).getWest();
                        player.map.getRoom(number);


                    } else if (direction.equalsIgnoreCase("Exit")) {
                        return;
                    } else {
                        System.out.println("Please enter a valid direction enter N,E,S,W");

                    }

                    Map.getRooms().get(roomID).setHasVisted(true);


                    roomID = Player.getCurrentLocation();
                }
            }
        }
    }
}

