package com.ithd.stripe.stripepaymentsystem.util;

import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.util.Helpers.getTime;

public class ResponseConverter{

    public static BaseApiStripeResponse<?> trueAlert(Map<String, Object> body){
        return new BaseApiStripeResponse<>(getTime(), true, HttpStatus.OK.value(), body);
    }

    public static BaseApiStripeResponse<?> falseAlert(Map<String, Object> body) {
        return new BaseApiStripeResponse<>(getTime(), false, HttpStatus.FORBIDDEN.value(), body);
    }

}
