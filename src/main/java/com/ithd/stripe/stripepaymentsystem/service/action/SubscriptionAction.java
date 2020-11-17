package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface SubscriptionAction {
    BaseApiStripeResponse<?> creatAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    BaseApiStripeResponse<?> retrieveAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    BaseApiStripeResponse<?> deleteAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    BaseApiStripeResponse<?> findAllAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
}
