package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeProductsRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stripe/v1/products")
public interface StripeProductApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeProductsRequest stripeProducts) throws StripeException;

    @GetMapping("/findById")
    ResponseEntity<?> findById(@RequestBody StripeProductsRequest stripeProducts) throws StripeException;

    @PostMapping("/update")
    ResponseEntity<?> updateById(@RequestBody StripeProductsRequest stripeProducts) throws StripeException;

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody StripeProductsRequest stripeProducts) throws StripeException;

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteById(@RequestBody StripeProductsRequest stripeProducts) throws StripeException;
}
