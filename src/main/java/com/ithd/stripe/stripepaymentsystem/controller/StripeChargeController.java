package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeChargeApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeChargeRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeChargeService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeChargeController implements StripeChargeApi {

    private final StripeChargeService stripeChargeService;

    @Override
    public ResponseEntity<?> create(StripeChargeRequest stripeChargeRequest) throws StripeException {
       if(null == stripeChargeRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeChargeService.create(stripeChargeRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
