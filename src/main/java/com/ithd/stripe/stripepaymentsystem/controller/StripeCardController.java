package com.ithd.stripe.stripepaymentsystem.controller;


import com.ithd.stripe.stripepaymentsystem.api.StripeCardApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeCardRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeCardService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeCardController implements StripeCardApi {

    private final StripeCardService stripeCardService;

    @Override
    @SneakyThrows
    public ResponseEntity<?> create(@RequestBody StripeCardRequest stripeCardRequest) {
        if (null == stripeCardRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCardService.create(stripeCardRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> delete(String cardId, String customerId) {
        StripeCardRequest stripeCardRequest = StripeCardRequest.builder().customerId(customerId).cardId(cardId).build();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCardService.delete(stripeCardRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> retrieve(StripeCardRequest stripeCardRequest) throws StripeException {
        if (null == stripeCardRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCardService.retrieve(stripeCardRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findAll(StripeCardRequest stripeCardRequest) throws StripeException {
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCardService.findAll(stripeCardRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
