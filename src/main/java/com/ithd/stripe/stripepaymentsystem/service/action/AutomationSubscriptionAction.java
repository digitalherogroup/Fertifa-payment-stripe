package com.ithd.stripe.stripepaymentsystem.service.action;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeAutomationSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.stripe.exception.StripeException;

public interface AutomationSubscriptionAction {
    BaseApiStripeResponse<?> createAction(StripeAutomationSubscriptionRequest ccs) throws StripeException;
}
