//room#~Boolean~Room Description~items~puzzleId~Room Connections:(N,E,S,W layout)
/**
 * Class: Room
 *
 */
public class Room {
	private int roomID;
	private String roomName;
	private boolean hasVisted;
	private String roomDescrip;
	private int hasItem;
	private  int hasPuzzle;
	private int hasMonster;
	private int north;
	private int east;
	private int south;
	private int west;

	/**
	 * Constructor Room
	 * @param roomID
	 * @param roomName
	 * @param hasVisted
	 * @param roomDescrip
	 * @param northRoomId
	 * @param eastRoomId
	 * @param southRoomId
	 * @param westRoomId
	 */
	public Room(int roomID, String roomName, boolean hasVisted, String roomDescrip,int hasItem,int hasPuzzle,int hasMonster, int northRoomId,
				int eastRoomId, int southRoomId, int westRoomId) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.hasVisted = hasVisted;
		this.roomDescrip = roomDescrip;
		this.hasItem = hasItem;
		this.hasPuzzle = hasPuzzle;
		this.hasMonster = hasMonster;
		this.north = northRoomId;
		this.east = eastRoomId;
		this.south = southRoomId;
		this.west = westRoomId;
	}

	/**
	 * Method: getRoomID
	 * @return roomId
	 */
	public int getRoomID() {
		return roomID;
	}

	/**
	 * Method: setRoomID()
	 * @param roomID
	 */
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	/**
	 * Method: getRoomName()
	 * @return room name
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * Method: getHasVisted9)
	 * @return true is room visited before
	 */
	public boolean getHasVisted() {
		return hasVisted;
	}

	/**
	 * Method: setHasVisted()
	 * sets to true if room visited before
	 * @param hasVisted
	 */
	public void setHasVisted(boolean hasVisted) {
		this.hasVisted = hasVisted;
	}

	/**
	 * Method: setHasItem()
	 * sets if room has an item
	 * @param hasItem
	 */

	public void setHasItem(int hasItem) {
		this.hasItem = hasItem;
	}

	/**
	 * Method: setHasPuzzle()
	 * set if room has a puzzle
	 * @param hasPuzzle
	 */
	public void setHasPuzzle(int hasPuzzle) {
		this.hasPuzzle = hasPuzzle;
	}


	/**
	 * Method: getRoomDescrip()
	 * @return room Description
	 */
	public String getRoomDescrip() {
		return roomDescrip;
	}

	/**
	 * Method: getNorth()
	 * @return north room information
	 */
	public int getNorth() {
		return north;
	}

	/**
	 * Method: getEast()
	 * @return east room information
	 */
	public int getEast() {
		return east;
	}

	/**
	 * Method: getSouth()
	 * @return south room information
	 */
	public int getSouth() {
		return south;
	}

	/**
	 * Method: getWest()
	 * @return west room information
	 */
	public int getWest() {
		return west;
	}

	/**
	 * Method: getHasItem()
	 * @return hasItem
	 */

	public int getHasItem() {
		return hasItem;
	}
	/**
	 * Method: getHasPuzzle()
	 * @return has Puzzle
	 */
	public int getHasPuzzle() {
		return hasPuzzle;
	}
	/**
	 *Methos: getHasMonster()
	 * @return has Monster
	 */
	public int getHasMonster() {
		return hasMonster;
	}

	/**
	 * Method: setHasMonster();
	 * @param hasMonster
	 */
	public void setHasMonster(int hasMonster) {
		this.hasMonster = hasMonster;
	}
}




