/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building{
  private Hashtable<String, Boolean> collection;

  /**
   * Constructs a library using the Building super constructor and initializes the collection Hashtable
   * @param name String name of the library
   * @param address String address of the library
   * @param nFloors int number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean> ();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds a title to the collection Hashtable with an availability value set to true
   * @param title String name of the book being added to the collections Hashtable
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Removes a book from the collection Hashtable if that book exists in the collection and returns a message that the book has been removed
   * @param title String name of the book being removed from the collection Hashtable
   * @return String message that the book has been removed from the library's collection
   */
  public String removeTitle(String title) {
    if (!this.containsTitle(title)){
      throw new RuntimeException("This book is not in the library's collection.");
    }
    this.collection.remove(title);
    return title + " has been removed from the " + this.getName() + " library collection.";
  }

  /**
   * Sets the availability value for the book with String title to false if the book is available
   * @param title String name of the book being modified in availability to false
   */
  public void checkOut(String title){
    if(!this.isAvailable(title)) {
      throw new RuntimeException("This book is already checked out.");
    }
    this.collection.replace(title, false);
    System.out.println("You have successfully checked out the book " + title + ".");
  }

  /**
   * Sets the availability value for the book with String title to true if the book is not already available
   * @param title String name of the book being modified in availability to true
   */
  public void returnBook(String title) {
    if(this.isAvailable(title)) {
      throw new RuntimeException("This book is not checked out.");
    }
    this.collection.replace(title, true);
    System.out.println("You have successfully returned the book " + title + ".");
  }

  /**
   * Returns true/false if the title exists in the collection Hashtable
   * @param title String being checked in the collection Hashtable
   * @return true/false if the title is contained in the collection Hashtable
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Returns true/false if the book is available if it exists in the collection Hashtable
   * @param title String title of the book whose collection Hashtable value is being checked
   * @return the boolean availabiility of the title
   */
  public boolean isAvailable(String title) {
    if(!this.containsTitle(title)) {
      throw new RuntimeException("This book is not in the library's collection.");
    }
    return this.collection.get(title);
  }
  
  /**
   * Prints the collection Hashtable with the names of the books and their current availability
   */
  public void printCollection() {
    System.out.println(this.collection);
  }

  public static void main(String[] args) {
    Library neilson = new Library("Neilson", null, 4);
    System.out.println(neilson);
    neilson.addTitle("Curious George");
    neilson.addTitle("The Great Gatsby");
    neilson.printCollection();
    neilson.checkOut("Curious George");
    neilson.printCollection();
    neilson.returnBook("Curious George");
    //neilson.returnBook("Curious George");
    System.out.println(neilson.removeTitle("Curious George"));
    neilson.printCollection();
  }
  
  }