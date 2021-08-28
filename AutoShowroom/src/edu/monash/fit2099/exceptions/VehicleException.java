package edu.monash.fit2099.exceptions;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class VehicleException extends Exception{
    /**
     * @param message exception message content - String type
     */
    public VehicleException(String message) {
        super(message);
    }
}
