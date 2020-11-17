package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeChargeRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stripe/v1/charge")
public interface StripeChargeApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeChargeRequest stripeChargeRequest) throws StripeException;
}
