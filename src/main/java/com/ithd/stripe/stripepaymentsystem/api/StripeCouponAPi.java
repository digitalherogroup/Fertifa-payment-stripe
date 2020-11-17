package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCouponRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stripe/v1/coupon")
public interface StripeCouponAPi {
    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeCouponRequest stripeCouponRequest) throws StripeException;

    @GetMapping("/retrieve")
    ResponseEntity<?> retrieve(@RequestBody StripeCouponRequest stripeCouponRequest);

    @DeleteMapping("/delete")
    ResponseEntity<?> deleteById(@RequestBody StripeCouponRequest stripeCouponRequest);

    @GetMapping("/findAll")
    ResponseEntity<?> findAll(@RequestBody StripeCouponRequest stripeCouponRequest);
}
