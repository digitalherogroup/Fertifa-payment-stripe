package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCouponRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface CouponAction {
    BaseApiStripeResponse<?> findAllAction(StripeCouponRequest stripeCouponRequest);
    BaseApiStripeResponse<?> createAction(StripeCouponRequest stripeCouponRequest) throws StripeException;
    BaseApiStripeResponse<?> retrieveAction(StripeCouponRequest stripeCouponRequest);
    BaseApiStripeResponse<?> deleteByIdAction(StripeCouponRequest stripeCouponRequest);
}
