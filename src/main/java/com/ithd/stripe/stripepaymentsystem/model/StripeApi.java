package com.ithd.stripe.stripepaymentsystem.model;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCardRequest;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeCustomerRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.Stripe;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import com.stripe.param.PriceCreateParams;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StripeApi extends Stripe {

    private Client client;
    private StripeCustomerRequest users;
    private Card card;
    private Customer customer;
    private StripeCardRequest stripeCard;
    private StripeCharge<?> stripeCharge;
    private PriceCreateParams priceCreateParams;
    private Subscription subscription;
    private BaseApiStripeResponse stripeProducts;
    private Invoice invoice;
}
