package com.ithd.stripe.stripepaymentsystem.model;

import com.ithd.stripe.stripepaymentsystem.constances.StripeConstance;
import com.stripe.Stripe;
import org.springframework.stereotype.Component;

@Component
public class Client {

    public Client() {
        Stripe.apiKey = StripeConstance.API_KEY;
    }
}
