package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeCouponAPi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeCouponRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeCouponService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeCouponController implements StripeCouponAPi {

    private final StripeCouponService stripeCouponService;

    @Override
    public ResponseEntity<?> create(StripeCouponRequest stripeCouponRequest) throws StripeException {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCouponService.create(stripeCouponRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> retrieve(StripeCouponRequest stripeCouponRequest) {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCouponService.retrieve(stripeCouponRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> deleteById(StripeCouponRequest stripeCouponRequest) {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCouponService.deleteById(stripeCouponRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @Override
    public ResponseEntity<?> findAll(StripeCouponRequest stripeCouponRequest) {
        ResponseEntity<BaseApiStripeResponse<?>> response = stripeCouponService.findAll(stripeCouponRequest);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
}
