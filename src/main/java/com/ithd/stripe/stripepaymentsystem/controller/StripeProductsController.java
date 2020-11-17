package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeProductApi;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeProductsRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.IdNotIncludedException;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.NoProductNameException;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeProductService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeProductsController implements StripeProductApi {

    private final StripeProductService stripeProductService;

    @SneakyThrows
    @Override
    public ResponseEntity<?> create(@RequestBody StripeProductsRequest stripeProducts) {
        if (null == stripeProducts) throw new ObjectNullException();
        if (stripeProducts.getName().isEmpty()) throw new NoProductNameException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeProductService.create(stripeProducts);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findById(@RequestBody StripeProductsRequest stripeProducts) throws StripeException {
        if (null == stripeProducts) throw new ObjectNullException();
        if (null == stripeProducts.getId() || stripeProducts.getId().isEmpty()) throw new IdNotIncludedException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeProductService.findById(stripeProducts);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> updateById(StripeProductsRequest stripeProducts) throws StripeException {
        if (null == stripeProducts) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeProductService.updateById(stripeProducts);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findAll(StripeProductsRequest stripeProducts) throws StripeException {
        if (null == stripeProducts) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeProductService.finaAll(stripeProducts);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> deleteById(StripeProductsRequest stripeProducts) throws StripeException {
        if (null == stripeProducts) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeProductService.deleteById(stripeProducts);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
