package com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions;

public class ProductServiceException extends RuntimeException {
    public ProductServiceException() {
        super("The type must be \"service\" or \"good\"");
    }
}
