package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCouponRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeCouponService {
    ResponseEntity<BaseApiStripeResponse<?>> create(StripeCouponRequest stripeCouponRequest) throws StripeException;

    ResponseEntity<BaseApiStripeResponse<?>> retrieve(StripeCouponRequest stripeCouponRequest);

    ResponseEntity<BaseApiStripeResponse<?>> deleteById(StripeCouponRequest stripeCouponRequest);

    ResponseEntity<BaseApiStripeResponse<?>> findAll(StripeCouponRequest stripeCouponRequest);
}
