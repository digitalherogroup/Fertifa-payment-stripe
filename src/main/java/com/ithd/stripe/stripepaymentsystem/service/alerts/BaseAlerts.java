package com.ithd.stripe.stripepaymentsystem.service.alerts;

import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;

import java.util.Map;

public interface BaseAlerts {
    BaseApiStripeResponse<?> trueAlert(Map<String, Object> body);
    BaseApiStripeResponse<?> falseAlert(Map<String, Object> body);
}
