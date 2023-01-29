package practice;

public class Room 
{
	Building building;
	int roomNumber;
	int roomCapacity;
	
	/**
	 * Constructor to create room with given building object and capacity
	 * 
	 * @param building
	 * @param room
	 * @param capacity
	 */
	public Room(Building building, int room, int capacity) {
		super();
		this.building = building;
		this.roomNumber = room;
		this.roomCapacity = capacity;
	}
	
	
	/**
	 * Method to return building object for current Room 
	 * 
	 * @return Building
	 */
	public Building getBuilding() {
		return building;
	}
	
	/**
	 * Method to return current room capacity
	 * 
	 * @return int
	 */
	public int getRoomCapacity() {
		return roomCapacity;
	}
	
	/**
	 * Method to set current room capacity
	 * 
	 * @param roomCapacity
	 */
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	@Override
	public String toString() {
		return building + " bouilding, Room " + roomNumber + " ( seats " + roomCapacity + " )";
	}
}
