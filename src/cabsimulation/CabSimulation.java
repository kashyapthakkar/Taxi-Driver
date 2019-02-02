/*
I, Kashyap Thakkar, 000742712 certify that this material is my original work. No other person's work has been used without due acknowledgement.
*/
package cabsimulation;

import java.util.Scanner;


public class CabSimulation {

    /**
     * 
     * @param args main method for our program
     */
    public static void main(String[] args) {
        int cabChoice = 1111, tripTime = 0;                                         //int variables for main method
        double rate,weight;                                                         //double variables for main method
        String seat;                                                                //String variables for main method
        boolean front;                                                              //boolean variables for main method

        Scanner input = new Scanner(System.in);                                     //scanner for taking inputs

        System.out.printf("What is today's rate? ");
        rate = input.nextDouble();                                                  //rate per minutes   

        Cab first = new Cab(1111);                                                  //class object for cabID 1111
        Cab second = new Cab(2222);                                                 //class object for cabID 2222
        //Cab current = first;
        
        Cab.setRate(rate);
        /*
        loop for our main method till user enter a ID 
        which is not 1111 or 2222
        */
        while (true) {
            System.out.printf("\nWhich Cab? ");
            cabChoice = input.nextInt();
            if (cabChoice == 1111 || cabChoice == 2222) {

                System.out.printf("\nNew passenger weight (kg): ");
                weight = input.nextDouble();

                while (true) {
                    System.out.printf("\nIn front seat? (yes/no) ");
                    seat = input.next();
                    if ("yes".equals(seat) || "y".equals(seat)) {
                        front = true;
                        break;
                    } else if ("no".equals(seat) || "n".equals(seat)) {
                        front = false;
                        break;
                    } else {
                        System.out.println("\nInvalid Input.");
                    }
                }
                Passenger passenger = new Passenger(weight, front);                 //passanger object
                if (cabChoice == 1111) {
                    System.out.println(first.pickUp(passenger));                    //pickUp method from Cab

                    System.out.print("\nHow long is the trip in minutes? ");
                    tripTime = input.nextInt();
                    first.dropOff(tripTime);                                        //tripTime method from Cab
                    
                } else {
                 

                    System.out.println(second.pickUp(passenger));

                    System.out.print("\nHow long is the trip in minutes? ");
                    tripTime = input.nextInt();

                    second.dropOff(tripTime);                                       //tripTime method from Cab
                }

            } else {
                break;
            }

        }
        //method call from cab
        first.endOfShift();
        second.endOfShift();
        //method call from cab
        System.out.println(first.report());
        System.out.println(second.report());
    }

}
