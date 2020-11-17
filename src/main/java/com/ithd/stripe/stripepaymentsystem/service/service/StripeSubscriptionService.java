package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeSubscriptionService {
    ResponseEntity<BaseApiStripeResponse<?>> create(StripeSubscriptionRequest stripeSubscriptionRequest);
    ResponseEntity<BaseApiStripeResponse<?>>  retrieve(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>>  delete(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>>  findAll(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
}
