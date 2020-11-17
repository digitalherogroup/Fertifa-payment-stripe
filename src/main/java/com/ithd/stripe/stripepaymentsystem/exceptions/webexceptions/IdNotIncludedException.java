package com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions;

public class IdNotIncludedException extends RuntimeException {

    public IdNotIncludedException() {
        super("Please provide with product id");
    }
}
