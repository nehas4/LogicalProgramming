package practice;

public class Building 
{
	String buildingName;
	int numberFloors;
	String campusLocation;
	
	/**
	 * Constructor to create Building with given name, floors and campus details
	 * 
	 * @param name
	 * @param floors
	 * @param campus
	 */
	public Building(String name, int floors, String campus) 
	{
		super();
		this.buildingName = name;
		this.numberFloors = floors;
		this.campusLocation = campus;
	}

	/**
	 * Method to return current building name
	 * 
	 * @return String
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * Method to return current building's campus name
	 * 
	 * @return String
	 */
	public String getCampus() {
		return campusLocation;
	}

	/**
	 * Method to compare the current building's floor with the given other building
	 * 
	 * @param otherBuilding
	 * @return int
	 */
	public int hasMoreFloors(Building otherBuilding)
	{
		return Integer.compare(this.numberFloors, otherBuilding.numberFloors);
	}

	@Override
	public String toString() {
		return buildingName + " building (" + numberFloors +" floors), " + campusLocation + " campus";
	}
}