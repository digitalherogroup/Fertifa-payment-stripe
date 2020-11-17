package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCardRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeCardService {

    ResponseEntity<BaseApiStripeResponse<?>> create(StripeCardRequest stripeCardRequest);
    ResponseEntity<BaseApiStripeResponse<?>> delete(StripeCardRequest stripeCardRequest);
    ResponseEntity<BaseApiStripeResponse<?>> retrieve(StripeCardRequest stripeCardRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> findAll(StripeCardRequest stripeCardRequest) throws StripeException;
}
