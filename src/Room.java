//room#~Boolean~Room Description~items~puzzleId~Room Connections:(N,E,S,W layout)
public class Room {
	private String roomId;
	private boolean isVisited;
	private String roomDescription;
	private String puzzleId;
	private String northRoomId;
	private String eastRoomId;
	private String southRoomId;
	private String westRoomId;
	
	public Room(String roomId, boolean isVisited, String roomDescription,
			String puzzleId, String northRoomId, String eastRoomId, String southRoomId, String westRoomId)
	{
		this.roomId = roomId;
		this.isVisited = isVisited;
		this.roomDescription = roomDescription;
		this.puzzleId = puzzleId;
		this.northRoomId = northRoomId;
		this.eastRoomId = eastRoomId;
		this.southRoomId = southRoomId;
		this.westRoomId = westRoomId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public String getPuzzleId() {
		return puzzleId;
	}

	public void setPuzzleId(String puzzleId) {
		this.puzzleId = puzzleId;
	}

	public String getNorthRoomId() {
		return northRoomId;
	}

	public void setNorthRoomId(String northRoomId) {
		this.northRoomId = northRoomId;
	}

	public String getEastRoomId() {
		return eastRoomId;
	}

	public void setEastRoomId(String eastRoomId) {
		this.eastRoomId = eastRoomId;
	}

	public String getSouthRoomId() {
		return southRoomId;
	}

	public void setSouthRoomId(String southRoomId) {
		this.southRoomId = southRoomId;
	}

	public String getWestRoomId() {
		return westRoomId;
	}

	public void setWestRoomId(String westRoomId) {
		this.westRoomId = westRoomId;
	}


}
