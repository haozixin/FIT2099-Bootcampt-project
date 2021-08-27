package edu.monash.fit2099.utility;

import java.util.Random;

public class GenerateId {
    public static String nextID(){
        Random r = new Random();
        int low = 100000;//using literal values is not a good idea, replace them with input parameters
        int high = 999999;
        return String.valueOf(r.nextInt(high - low) + low);
    }
}
