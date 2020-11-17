package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeProductsRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface ProductAction {
    BaseApiStripeResponse<?> updateByIdAction(StripeProductsRequest stripeProductsRequest) throws StripeException;
    BaseApiStripeResponse<?> findAllAction(StripeProductsRequest stripeProductsRequest) throws StripeException;
    BaseApiStripeResponse<?> deleteByIdAction(StripeProductsRequest stripeProductsRequest) throws StripeException;
    BaseApiStripeResponse<?> findByIdAction(StripeProductsRequest stripeProductsRequest) throws StripeException;
    BaseApiStripeResponse<?> creatAction(StripeProductsRequest stripeProductsRequest) throws StripeException;
}
