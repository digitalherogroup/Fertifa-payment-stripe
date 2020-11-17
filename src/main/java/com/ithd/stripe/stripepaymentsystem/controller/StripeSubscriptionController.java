package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeSubscriptionApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeSubscriptionService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeSubscriptionController implements StripeSubscriptionApi {

    private final StripeSubscriptionService stripeSubscriptionService;

    @Override
    public ResponseEntity<?> create(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException, ObjectNullException {
        if (null == stripeSubscriptionRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeSubscriptionService.create(stripeSubscriptionRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> retrieve(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        if (null == stripeSubscriptionRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeSubscriptionService.retrieve(stripeSubscriptionRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> delete(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        if(null == stripeSubscriptionRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeSubscriptionService.delete(stripeSubscriptionRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findAll(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        if(null == stripeSubscriptionRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeSubscriptionService.findAll(stripeSubscriptionRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
