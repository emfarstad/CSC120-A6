/* This is a stub for the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructs a cafe with the Building super constructor parameters and sets the values int nCoffeeOunces, int nSugarPackets, int nCreams, and int nCups
     * @param name String name of the cafe  
     * @param address String address of the cafe
     * @param nFloors int number of floors in the cafe
     * @param nCoffeeOunces int ounces of coffee in stock
     * @param nSugarPackets int number of sugar packets in stock
     * @param nCreams int number of creams in stock
     * @param nCups int number of coffee cups in stock
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Restocks the amounts for nCoffeeOunces, nSugarPackes, nCreams, and nCups 
     * @param nCoffeeOunces int ounces of coffee added to the nCoffeeOunces stock
     * @param nSugarPackets int number of sugar packets added to the nSugarPackes stock
     * @param nCreams int number of creams added to the nCreams stock
     * @param nCups int number of cups added to the nCups stock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Decreases the stock of nCoffeeOUnces nSugarPackets, and nCreams by the amounts stated in the parameters, decreases nCups by one, and restocks the supply of all items if any of the values are less than 0
     * @param size int ounces of coffee decreased from nCoffeeOunces
     * @param nSugarPackets int number of sugar packets decreased from nSugarPackets
     * @param nCreams int number of creams decreased from nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if(size <= 0 || nSugarPackets < 0 || nCreams < 0) {
            throw new RuntimeException("The values entered are less than zero, this order cannot be completed.");
        }
        
        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            this.restock(100, 20, 20, 20);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups--;
    }
    
    /**
     * Prints the current values for nCoffeeOunces, nSugarPackets, nCreams, and nSugars
     */
    public void printStock() {
        System.out.println("Ounces of coffee: " + this.nCoffeeOunces + "\nSugar packes: " + nSugarPackets + "\nCreams: " + nCreams + "\nCups: " + nCups);
    }

    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", null, 3, 100, 30, 20, 7);
        campusCenter.printStock();
        campusCenter.sellCoffee(20, 2, 1);
        System.out.println(campusCenter);
        campusCenter.printStock();
        campusCenter.sellCoffee(90, 0, 0);
        campusCenter.printStock();
    }
    
}
