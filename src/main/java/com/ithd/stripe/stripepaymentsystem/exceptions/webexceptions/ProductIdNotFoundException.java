package com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions;

public class ProductIdNotFoundException extends RuntimeException{

    public ProductIdNotFoundException() {
        super("The id not found, please check again.");
    }
}
