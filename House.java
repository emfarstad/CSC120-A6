/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building{
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * Constructs a house using the Building super constructor parameters and boolean hasDiningRoom, and initializes the residents ArrayList
   * @param name String name of the house
   * @param address String address of the house
   * @param nFloors int number of floors in the hosue
   * @param hasDiningRoom Boolean if the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<> ();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Returns true or false depending on if the house has a dining room
   * @return boolean true/false if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the int number of residents
   * @return int number of residents in the house
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Adds the String name to the residents ArrayList for the house
   * @param name String name added to the residents ArrayList
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /**
   * Removes the String name resident from the residents ArrayList for the house if the String name is in the residents ArrayList
   * @param name String name removed from the residents ArrayList
   * @return a message saying that the String name has been removed from the house
   */
  public String moveOut(String name) {
    if(!residents.contains(name)) {
      throw new RuntimeException(name + " does not live in this house.");
    }
    residents.remove(name);
    return "Resident " + name + " has moved out of " + this.getName() + ".";
  } // return the name of the person who moved out

  /**
   * Returns true or false depending on if String person is a resident of the house
   * @param person String name checked to see if it is contained in the residents ArrayList  
   * @return Boolean true/false if the String person is a resident of the house 
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /**
   * Modified toString() method specifying the number of residents in the house and if there is a dining room
   * @return String message about the house's name, adress, number of floors, number of residents, and if there is a dining room
   */
  public String toString() {
    String diningRoom = "does not have";
    if(this.hasDiningRoom()) {
      diningRoom = "has";
    }
    return super.toString() + " that " + diningRoom + " a dining room and " + nResidents() + " residents.";
  }
  public static void main(String[] args) {
    House baldwin = new House("Baldwin", "15 Bedford Terrace Drive", 5, true);
    System.out.println(baldwin);
    System.out.println(baldwin.hasDiningRoom());
    System.out.println(baldwin.nResidents());
    baldwin.moveIn("Jordan");
    System.out.println(baldwin);
    System.out.println(baldwin.nResidents());
    System.out.println(baldwin.isResident("Jordan"));
    System.out.println(baldwin.isResident("Johanna"));
    System.out.println(baldwin.moveOut("Jordan"));

  }

}