package com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException() {
        super("Please add address in your request.");
    }
}
