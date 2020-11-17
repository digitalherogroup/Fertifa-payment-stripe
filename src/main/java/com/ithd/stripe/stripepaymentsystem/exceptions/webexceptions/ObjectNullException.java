package com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions;

public class ObjectNullException extends RuntimeException {


    public ObjectNullException() {
        super("Details are missing, please check your inputs ad try again.");
    }

}
