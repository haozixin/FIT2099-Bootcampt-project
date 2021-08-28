package edu.monash.fit2099.exceptions;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class SedanException extends VehicleException{
    /**
     * @param message exception message content - String type
     */
    public SedanException(String message) {
        super(message);
    }
}
