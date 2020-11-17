package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCardRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface CardAction {
    BaseApiStripeResponse<?> createAction(StripeCardRequest stripeCardRequest);
    BaseApiStripeResponse<?> deleteAction(StripeCardRequest stripeCardRequest);
    BaseApiStripeResponse<?> retrieveAction(StripeCardRequest stripeCardRequest) throws StripeException;
    BaseApiStripeResponse<?> findAllAction(StripeCardRequest stripeCardRequest) throws StripeException;
}
