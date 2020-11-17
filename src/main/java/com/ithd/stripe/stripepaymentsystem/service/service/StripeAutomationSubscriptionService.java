package com.ithd.stripe.stripepaymentsystem.service.service;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeAutomationSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;

public interface StripeAutomationSubscriptionService {
    ResponseEntity<BaseApiStripeResponse<?>> create(StripeAutomationSubscriptionRequest ccs) throws StripeException;
}
