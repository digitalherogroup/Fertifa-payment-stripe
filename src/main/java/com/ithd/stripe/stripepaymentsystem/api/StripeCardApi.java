package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCardRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stripe/v1/card")
public interface StripeCardApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeCardRequest stripeCardRequest) throws StripeException;

    @DeleteMapping("/delete/{cardId}/{customerId}")
    ResponseEntity<?> delete(@PathVariable String cardId, @PathVariable String customerId);

    @GetMapping("/retrieve")
    ResponseEntity<?> retrieve(@RequestBody StripeCardRequest stripeCardRequest) throws StripeException;

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody StripeCardRequest stripeCardRequest) throws StripeException;
}
