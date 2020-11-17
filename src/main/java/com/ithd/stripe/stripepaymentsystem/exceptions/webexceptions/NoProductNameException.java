package com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions;

public class NoProductNameException extends RuntimeException{
    public NoProductNameException() {
        super("Please fill the product name");
    }
}
