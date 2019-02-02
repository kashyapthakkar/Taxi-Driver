
package cabsimulation;

/**
 *
 * @author Kashyap Thakkar
 */
public class Cab {
    private  double companyTotalFare = 0;
    private static double rate;
    private double taxiTotalFare;
    private int tripCounter = 1;
    private int cabID;
    private Passenger rider = null;
    /**
     * constructor to connect with our main method
     * @param cabID  cabID 
     */
    public Cab(int cabID){
        this.cabID = cabID;
        
    }
    /**
     * Shows a string with front seat and airbag status.
     * @param rider Passenger
     * @return cab status.
     */
    public String pickUp(Passenger rider){
        this.rider = rider;
       if(rider.isInFrontSeat() && rider.getWeight() > 40){
           return "\nCab " + cabID + " pickup " + tripCounter++ + ".Passanger in front seat. Airbag is on." ;
       }else if(rider.isInFrontSeat()){
           return "\nCab " + cabID + " pickup " + tripCounter++ + ". Passanger in front seat.";
       }else{
           return "\nCab " + cabID + " pickup " + tripCounter++ + ".";
       }
    }
    /**
     * Calculates the taxiTotalFare and check if passenger not in the cab.
     * @param minutes tripTime
     * @return true or false.
     */
    public boolean dropOff(int minutes){
        if(rider == null){
            return false;
        }else{
            taxiTotalFare += (rate * minutes);
            return true;
        }
    }
    /**
     * add taxiTotalFare to companyTotalFare
     */
    public void endOfShift(){
        companyTotalFare += taxiTotalFare;
        
    }
    
    
    /**
     * calculate the share of each cab, and shows a string which cab owns how much share.
     * @return report of both cabs.
     */
    public String report(){
        double share = (taxiTotalFare / companyTotalFare) * 100;
         return "Cab " + cabID + " had " + (tripCounter - 1) + " trips and earned $" + taxiTotalFare + "( " + share +"% of day's total)."; 
    }
    /**
     * output rate
     * @return rate
     */
    public static double getRate(){
        return rate;
    }
    /**
     * set  the ret variable
     * @param rate rate
     */
    public static void setRate(double rate){
        Cab.rate = rate;
    }
}
