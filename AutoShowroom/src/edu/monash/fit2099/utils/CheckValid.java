package edu.monash.fit2099.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckValid {

    /**
     * A under boundary for the year when checking the input Date
     */
    private static final int START_YEAR_LIMIT = 1930;
    /**
     * A up boundary for the year when checking the input Date
     */
    private static final int END_YEAR_LIMIT = 2021;
    /**
     * Buyers' name(given/family) should be at least x length
     */
    private static final int NAME_UNDER_BOUNDARY = 2;
    /**
     * Buyers' name(given/family) should be up to x length
     */
    private static final int NAME_UP_BOUNDARY = 15;
    /**
     * Vehicle's Maker and Model should both with length at least x
     */
    private static final int V_UNDER_BOUNDARY = 3;
    /**
     * Vehicle's Maker and Model should both with length up to x
     */
    private static final int V_UP_BOUNDARY = 15;

    /**
     *
     * @param length input String value(input date) length
     * @param sDate input String value(input date)
     * @param format "yyyy-MM-dd" / "yyyy-MM" and so on
     * @return boolean value
     */
    public static boolean isLegalDate(int length, String sDate,String format) {
        //get the legal length of the specified format
        int legalLen = length;

        // they are definite un-legal if the date is null or have a different length with the legal's one
        if ((sDate == null) || (sDate.length() != legalLen)) {
            return false;
        }
        //after pass the first check
        DateFormat formatter = new SimpleDateFormat(format);
        // if input date is same with the one after transformation, means the value itself is legal(like 1999-2-90 will return false)
        try {
            //convert the string to a date
            //if month is 13 it will convert to 1(like a clock)
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean yearRange(String date){
        String year = date.substring(0,4);
        int yearInt = Integer.parseInt(year);
        if (START_YEAR_LIMIT<=yearInt && yearInt<=END_YEAR_LIMIT){
            return true;
        }else{
            return false;
        }
    }

    public static boolean buyerValidLength(String inputValue){
        boolean isValid=false;
        int length = inputValue.length();
        if(length>=NAME_UNDER_BOUNDARY && length<=NAME_UP_BOUNDARY){
            isValid=true;
        }
        return isValid;
    }
    public static boolean vehicleValidLength(String inputValue){
        boolean isValid=false;
        int length = inputValue.length();
        if(length>=V_UNDER_BOUNDARY && length<=V_UP_BOUNDARY){
            isValid=true;
        }
        return isValid;
    }
}
