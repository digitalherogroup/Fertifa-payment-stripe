package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeInvoiceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.InvoiceAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeInvoiceService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Invoice;
import com.stripe.param.InvoiceCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;

@Service
@RequiredArgsConstructor
public class StripeInvoiceImplementation implements StripeInvoiceService, InvoiceAction {

    private final GsonConverter gsonConverter;

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripeInvoiceRequest stripeCustomerRequest) throws StripeException {
        if (null == stripeCustomerRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = creatAction(stripeCustomerRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public BaseApiStripeResponse<?> creatAction(StripeInvoiceRequest stripeInvoiceRequest) throws StripeException {
        if (null == stripeInvoiceRequest) throw new ObjectNullException();
//        Map<String, Object> params = new HashMap<>();
//        params.put("customer", stripeInvoiceRequest.getCustomerId());
//        //params.put("price",stripeInvoiceRequest.getPrice());
//
//        Invoice invoice = Invoice.create(params);
        InvoiceCreateParams params =
                InvoiceCreateParams.builder()
                        .setCustomer(stripeInvoiceRequest.getCustomerId())
                        .build();

        Invoice invoice = Invoice.create(params);
        Map<String, Object> body = gsonConverter.convertToMapObject(invoice);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }
}
