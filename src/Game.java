import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private static ArrayList<Items> itemElements;
    //Making a change through AnasBranch on git
    //Puzzle Reader by Mart
    //Reading in files added through JosueBranch

    /**
     * main Method where file is read
     *
     * @param
     */
    public void play() throws NullPointerException, IOException {
    	
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
        try {
    		BufferedReader reader1 = new BufferedReader(new FileReader("items.txt"));
    		File f1 = new File("items.txt");
    		String line1 = reader1.readLine();
    		if(!f1.exists()) {
    			throw new FileNotFoundException();
    		}
    		itemElements = new ArrayList<Items>();
    		while(line1 != null) {
    			//System.out.println(line1);
    			String[] tokens1 = line1.trim().split("\\*");
    			Items y = new Items(Integer.parseInt(tokens1[0]), tokens1[1], tokens1[2], Boolean.parseBoolean(tokens1[3]),
    						Boolean.parseBoolean(tokens1[4]), Integer.parseInt(tokens1[5]), Integer.parseInt(tokens1[6]));
    			Map.addItems(y);
    			//itemElements.add(y);
    			
    			line1 = reader1.readLine();
    			
    		}
    		}
    		catch (FileNotFoundException e){
    			System.out.println("File not found!");			
    		}catch (IOException e) {
    			System.out.println("File Could not be accessed.");
    		}

        File monsterFile = new File("monsters1.txt");
        try {
            Scanner scanner = new Scanner(monsterFile).useDelimiter(":");
            while (scanner.hasNext()) {
                int monsterId = scanner.nextInt();
                //System.out.println(monsterId);
                String mName = scanner.next();

                //System.out.println(mName);
                String mdes = scanner.next();
                //System.out.println(mdes);
                int location = Integer.parseInt(String.valueOf(scanner.nextInt()));
                //System.out.println(location);
                int mHealth = scanner.nextInt();
                //System.out.println(mHealth);
                String attack1 = scanner.next();
                //System.out.println(attack1);
                int attackdam1 = scanner.nextInt();
                //System.out.println(attackdam1);
                String attack2 = scanner.next();
                //System.out.println(attack2);
                int attackdam2 = scanner.nextInt();
                //System.out.println(attackdam2);
                String attack3 = scanner.next();
                //System.out.println(attack3);
                int attackdam3 = scanner.nextInt();
                //System.out.println(attackdam3);
                String attack4 = scanner.next();
                //System.out.println(attack4);
                int attackdam4 = scanner.nextInt();
                //System.out.println(attackdam4);

                Map.addMonster(new Monster(monsterId,mName,mdes,location,mHealth,
                attack1,attackdam1,attack2,attackdam2,attack3,attackdam3,attack4,attackdam4));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        ArrayList<Puzzle> puzzles = puzzleReader();
        //set random puzzle based on rooms
        Map.randomizePuzzles(puzzles);
        /**
         * Instructions
         */
        System.out.println("============================================================================================");
        System.out.println("Instructions");
        System.out.println("Pick option by entering number next to it.");
        System.out.println("Move by entering a direction (example north or n)");
        System.out.println("End game at any time by entering 'Exit'");
        System.out.println("Enter 'help' for command menu");
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
                System.out.println("1. Move \n2. Search Area \n3. Check inventory ");
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
                else if (userInput.equalsIgnoreCase("2")) {
                    while (true) {
                        Scanner op = new Scanner(System.in);
                        player.playerStatus();
                        player.inspect();
                        System.out.println();
                        System.out.println("What do you want to do:");
                        System.out.println("1.Use Scouter\n2.pickup item\n3.drop item\n4.back");
                        String choose = input.nextLine();
                        if (choose.equalsIgnoreCase("1")) {
                            System.out.println("=========================================================================");
                            System.out.println("What do you want use the scouter on: ");
                            String ans = op.nextLine();
                            player.scout(ans);

                        } else if (choose.equalsIgnoreCase("2")) {
                            System.out.println("=========================================================================");
                            System.out.println("What do you want to pickup: ");
                            String userinp = op.nextLine();
                            player.pickup(userinp);
                        } else if (choose.equalsIgnoreCase("3")) {
                            System.out.println("=========================================================================");
                            System.out.println("What do you want to drop: ");
                            String userinp = op.nextLine();
                            player.drop(userinp);
                        } else if (choose.equalsIgnoreCase("4")) {
                            break;
                        } else {
                            System.out.println("Invalid please enter valid input");
                        }
                    }
                }
                /**
                 * displays user inventory
                 * gives player option to equip and UnEquip Items
                 * gives player option if using healing items
                 */
                else if (userInput.equalsIgnoreCase("3")) {
                    while (true) {
                        player.playerStatus();
                        Player.printInventory();
                        Scanner eq = new Scanner(System.in);
                        System.out.println();
                        System.out.println("What do you want to do:");
                        System.out.println("1.Equip\n2.Unequipped\n3.Heal\n4.Go back");
                        String choose = input.nextLine();
                        if(choose.equalsIgnoreCase("1"))
                        {
                            player.playerStatus();
                            Player.printInventory();
                            System.out.println("What do you want to equip: ");
                            String e = eq.nextLine();
                            Items.equip(e);
                        }
                        else if(choose.equalsIgnoreCase("2"))
                        {
                            player.playerStatus();
                            Player.printInventory();
                            System.out.println(("What do you want to unequip: "));
                            String ue = eq.nextLine();
                            Items.unEquip(ue);
                        }
                        else if(choose.equalsIgnoreCase("3"))
                        {
                            player.playerStatus();
                            Player.printInventory();
                            System.out.println("What item do you want to heal with: ");
                            String h = eq.nextLine();
                            Items.heal(h);

                        }
                        else if(choose.equalsIgnoreCase("4"))
                        {
                            break;
                        }
                        else {
                            System.out.println("Invalid please enter valid input");
                        }
                    }

                }
                else if (userInput.equalsIgnoreCase("exit")) {
                    return;
                }
                else {
                    System.out.println("Invalid input please try again.");
                }

            }
        }
        input.close();
    }

    private ArrayList<Puzzle> puzzleReader(){

        ArrayList<Puzzle> puzzles;
        //No puzzle control Vars

        puzzles = new ArrayList<Puzzle>();
        String desc = "";
        String hint = "";

        FileReader puzzle;
        try{
            puzzle = new FileReader("Puzzle.txt");
            BufferedReader br = new BufferedReader(puzzle);

            //no puzzle control vars skip first line
            br.readLine();

            //set up puzzles
            String puzzleText = br.readLine();
            do{
                //get puzzle
                String[] puzzleParams = puzzleText.split("\\*");
                //get puzzle description
                String check = br.readLine();
                do{
                    desc = desc + check + "\n";
                    check = br.readLine();
                }while(!check.equals("***"));
                //get hint
                check = br.readLine();
                do {
                    hint = hint + check;
                    check = br.readLine();
                }while(!check.equals("***"));
                //add puzzle
                Puzzle p = new Puzzle(puzzleParams[0],puzzleParams[1],desc,puzzleParams[2],3,hint,
                        Float.parseFloat(puzzleParams[3]),puzzleParams[4]);
                puzzles.add(p);
                desc = "";
                hint = "";

                puzzleText = br.readLine();
            }while(!puzzleText.equals("End"));
        }catch (IOException e){
            System.out.println(e);
        }

        return puzzles;
    }

}




