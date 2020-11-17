package com.ithd.stripe.stripepaymentsystem.controller;

import com.ithd.stripe.stripepaymentsystem.api.StripeAutomationSubscriptionApi;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeAutomationSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeAutomationSubscriptionService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StripeAutomationSubscriptionController implements StripeAutomationSubscriptionApi {

  private final StripeAutomationSubscriptionService stripeAutomationSubscriptionService;

  @Override
  public ResponseEntity<?> create(StripeAutomationSubscriptionRequest ccs) throws StripeException {
    if (null == ccs) throw new ObjectNullException();
    ResponseEntity<BaseApiStripeResponse<?>> response = stripeAutomationSubscriptionService.create(ccs);
    return new ResponseEntity<>(response.getBody(), response.getStatusCode());
  }
}
