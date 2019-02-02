
package cabsimulation;

/**
 *
 * @author Kashyap Thakkar
 */
public class Passenger {
    private double weight;
    private boolean inFrontSeat;
    
    /**
     * constructor for Cab  
     * @param weight passenger weight
     * @param front front.
     */
    public Passenger(double weight, boolean front){
        this.weight = weight;
        inFrontSeat = front;
    }
    /**
     * output weight
     * @return passenger weight
     */
    public double getWeight(){
        return weight;
    }
    /**
     * Check that is passenger in front seat
     * @return true or false
     */
    public boolean isInFrontSeat(){
        return inFrontSeat;
    }
    
}
