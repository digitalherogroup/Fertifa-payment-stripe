package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeChargeRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeChargeService {
    ResponseEntity<BaseApiStripeResponse<?>> create(StripeChargeRequest stripeChargeRequest) throws StripeException;
}
