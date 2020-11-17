package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripePriceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface PriceAction {
    BaseApiStripeResponse<?> creatAction(StripePriceRequest stripePrice) throws StripeException;
    BaseApiStripeResponse<?> findByIdAction(StripePriceRequest stripePrice) throws StripeException;
    BaseApiStripeResponse<?> findAllAction(StripePriceRequest stripePrice) throws StripeException;
}
