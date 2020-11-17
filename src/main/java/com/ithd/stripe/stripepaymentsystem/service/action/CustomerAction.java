package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCustomerRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface CustomerAction {
    BaseApiStripeResponse<?> creatAction(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
    BaseApiStripeResponse<?> findByIdAction(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
    BaseApiStripeResponse<?> deleteByIdAction(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
    BaseApiStripeResponse<?> findAllAction(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
}
