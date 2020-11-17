package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeCustomerApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeCustomerRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeCustomerService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeCustomerController implements StripeCustomerApi {

    private final StripeCustomerService stripeCustomerService;

    @Override
    public ResponseEntity<?> create(StripeCustomerRequest stripeCustomerRequest) throws StripeException {
        if (null == stripeCustomerRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCustomerService.create(stripeCustomerRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findById(StripeCustomerRequest stripeCustomerRequest) throws StripeException {
        if (null == stripeCustomerRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCustomerService.findById(stripeCustomerRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findAll(StripeCustomerRequest stripeCustomerRequest) throws StripeException {
        if (null == stripeCustomerRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCustomerService.findAll(stripeCustomerRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> deleteById(StripeCustomerRequest stripeCustomerRequest) throws StripeException {
        if (null == stripeCustomerRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCustomerService.deleteById(stripeCustomerRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
