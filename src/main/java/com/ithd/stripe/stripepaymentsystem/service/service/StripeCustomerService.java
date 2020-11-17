package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCustomerRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeCustomerService {
    ResponseEntity<BaseApiStripeResponse<?>> create(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> findById(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> deleteById(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> findAll(StripeCustomerRequest stripeCustomerRequest) throws StripeException;
}

