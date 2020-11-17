package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripePriceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripePriceService {

    ResponseEntity<BaseApiStripeResponse<?>> create(StripePriceRequest stripePriceRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> findById(StripePriceRequest stripePriceRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> findAll(StripePriceRequest stripePrice) throws StripeException;
}
