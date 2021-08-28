package edu.monash.fit2099.utils;

import java.util.Random;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class GenerateId {

    /**
     * A function to generate random ID
     * @return a String - random ID
     */
    public static String nextID(){
        Random r = new Random();
        int low = 100000;//using literal values is not a good idea, replace them with input parameters
        int high = 999999;
        return String.valueOf(r.nextInt(high - low) + low);
    }
}
