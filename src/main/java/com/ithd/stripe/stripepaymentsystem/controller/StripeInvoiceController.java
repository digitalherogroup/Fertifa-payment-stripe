package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeInvoiceApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeInvoiceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeInvoiceService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeInvoiceController implements StripeInvoiceApi {

    private final StripeInvoiceService stripeInvoiceService;
    @Override
    public ResponseEntity<?> create(StripeInvoiceRequest stripeInvoiceRequest) throws StripeException {
        if (null == stripeInvoiceRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeInvoiceService.create(stripeInvoiceRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
