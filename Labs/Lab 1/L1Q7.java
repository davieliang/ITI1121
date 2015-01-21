// Test.java --- Tests Combination, DoorLock and SecurityAgent
// Author          : Marcel Turcotte
// Created On      : Mon Jan 26 14:24:07 2004
// Last Modified By: Marcel Turcotte
// Last Modified On: Thu Jan 10 10:22:16 2008

public class L1Q7 {

    public static void main( String[] args ) {

        // Creates a new security agent called bob!
        SecurityAgent bob = new SecurityAgent();

        // Ask bob to give us access to the door lock
        DoorLock aLock = bob.getDoorLock();

        // Let's find bob's secret combination
        Combination c = null;
        boolean open = false;
        int iter = 0;

        while ( ! open ) {

            // bob knows the combination and will
            // re-activate the DoorLock

            if ( ! aLock.isActivated() ) {
            bob.activateDoorLock();
            }

            // let's create a new random combination

            int first = (int) ( Math.random()*5 ) + 1;
            int second = (int) ( Math.random()*5 ) + 1;
            int third = (int) ( Math.random()*5 ) + 1;

            c = new Combination( first, second, third );
            
            // if this combination opens the lock
            // we're done.
            if ( aLock.open( c ) ) {
            open = true;
            }

            iter++;
        }

        System.out.println( "Success!" );
        System.out.println( "Number of attemtps: " + iter );
        System.out.println( "The combination is: " + c );
    }
}