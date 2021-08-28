package edu.monash.fit2099.exceptions;

/**
 * @author Zixin
 * @version 5.0(week5-bootcamp-version)
 * @see "https://lms.monash.edu/mod/page/view.php?id=8894316"
 */
public class BidException extends Exception{

    /**
     * @param message exception message content - String type
     */
    public BidException(String message) {
        super(message);
    }
}
