package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripePriceApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripePriceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripePriceService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class StripePriceController implements StripePriceApi {

    private final StripePriceService stripePriceService;

    @Override
    @SneakyThrows
    public ResponseEntity<?> create(@RequestBody StripePriceRequest stripePriceRequest) {
        if (null == stripePriceRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripePriceService.create(stripePriceRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findById(StripePriceRequest stripePriceRequest) throws StripeException {
        if (null == stripePriceRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripePriceService.findById(stripePriceRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findAll(StripePriceRequest stripePriceRequest) throws StripeException {
        ResponseEntity<BaseApiStripeResponse<?>> response = stripePriceService.findAll(stripePriceRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
