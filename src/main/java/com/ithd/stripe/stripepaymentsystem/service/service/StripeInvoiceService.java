package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeInvoiceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeInvoiceService {
    ResponseEntity<BaseApiStripeResponse<?>> create(StripeInvoiceRequest stripeInvoiceRequest) throws StripeException;
}
