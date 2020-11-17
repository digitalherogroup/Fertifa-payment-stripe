package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeProductsRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeProductService {

    ResponseEntity<BaseApiStripeResponse<?>> create(StripeProductsRequest stripeProductsRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> findById(StripeProductsRequest stripeProductsRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> updateById(StripeProductsRequest stripeProductsRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> finaAll(StripeProductsRequest stripeProductsRequest) throws StripeException;
    ResponseEntity<BaseApiStripeResponse<?>> deleteById(StripeProductsRequest stripeProductsRequest) throws StripeException;
}
