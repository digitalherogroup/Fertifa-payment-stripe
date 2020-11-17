package com.ithd.stripe.stripepaymentsystem.api;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeAutomationSubscriptionRequest;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stripe/v1/c/c/s")
public interface StripeAutomationSubscriptionApi {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody StripeAutomationSubscriptionRequest ccs) throws StripeException;
}
