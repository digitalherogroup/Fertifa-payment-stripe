package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeInvoiceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface InvoiceAction {
    BaseApiStripeResponse<?> creatAction(StripeInvoiceRequest stripeInvoiceRequest) throws StripeException;
}
