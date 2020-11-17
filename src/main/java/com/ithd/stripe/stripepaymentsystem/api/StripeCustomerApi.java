package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCustomerRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stripe/v1/customer")
public interface StripeCustomerApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeCustomerRequest stripeCustomerRequest) throws StripeException;

    @GetMapping("/retrieve")
    ResponseEntity<?> findById(@RequestBody StripeCustomerRequest stripeCustomerRequest) throws StripeException;

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody StripeCustomerRequest stripeCustomerRequest) throws StripeException;

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteById (@RequestBody StripeCustomerRequest stripeCustomerRequest) throws StripeException;
}
