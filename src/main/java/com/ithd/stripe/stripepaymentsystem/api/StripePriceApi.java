package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripePriceRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stripe/v1/price")
public interface StripePriceApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripePriceRequest stripeProducts) throws StripeException;

    @GetMapping("/retrieve")
    ResponseEntity<?> findById(@RequestBody StripePriceRequest stripePriceRequest) throws StripeException;

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody StripePriceRequest stripePriceRequest) throws StripeException;
}
