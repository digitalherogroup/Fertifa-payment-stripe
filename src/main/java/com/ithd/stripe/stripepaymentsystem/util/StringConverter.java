package com.ithd.stripe.stripepaymentsystem.util;

public class StringConverter {

    public static String covertErrorMessage(String errorMessage) {
        if(errorMessage.contains(";")) {
            return errorMessage.substring(0, errorMessage.indexOf(";"));
        }
        return errorMessage;
    }
}
