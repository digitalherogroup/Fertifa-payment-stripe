package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeChargeRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface ChargeAction {
    BaseApiStripeResponse<?> creatAction(StripeChargeRequest stripeChargeRequest) throws StripeException;
}
