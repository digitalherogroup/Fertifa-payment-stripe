package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeSubscriptionRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stripe/v1/sub")
public interface StripeSubscriptionApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException, ObjectNullException;
    @GetMapping("/retrieve")
    ResponseEntity<?> retrieve(@RequestBody StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    @DeleteMapping("/delete")
    ResponseEntity<?> delete(@RequestBody StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException;
}
