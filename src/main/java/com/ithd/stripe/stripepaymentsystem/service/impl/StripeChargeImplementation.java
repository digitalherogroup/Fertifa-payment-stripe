package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeChargeRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.ChargeAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeChargeService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.DEFAULT_CHARGE_MESSAGE;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;
import static com.ithd.stripe.stripepaymentsystem.util.StringConverter.covertErrorMessage;

@Service
@RequiredArgsConstructor
public class StripeChargeImplementation implements StripeChargeService, ChargeAction {

    private final GsonConverter gsonConverter;

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripeChargeRequest stripeChargeRequest) throws StripeException {
        if (null == stripeChargeRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = creatAction(stripeChargeRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public BaseApiStripeResponse<?> creatAction(StripeChargeRequest stripeChargeRequest) throws StripeException {
        Map<String, Object> body = new HashMap<>();
        Customer customer = null;
        Card card = null;

        if (Customer.retrieve(stripeChargeRequest.getCustomerId()) == null) throw new ObjectNullException();
        try {
            customer = Customer.retrieve(stripeChargeRequest.getCustomerId());
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        if (customer.getSources().retrieve(stripeChargeRequest.getCardId()) == null) throw new ObjectNullException();
        try {
            card = (Card) customer.getSources().retrieve(stripeChargeRequest.getCardId());
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", stripeChargeRequest.getPrice() * 100);
        chargeParams.put("currency", "gbp");
        chargeParams.put("customer", customer.getId());
        chargeParams.put("card", card.getId());
        if (stripeChargeRequest.getDescription() == null || stripeChargeRequest.getDescription().isEmpty()) {
            chargeParams.put("description", DEFAULT_CHARGE_MESSAGE);
        } else {
            chargeParams.put("description", stripeChargeRequest.getDescription());
        }
        if (stripeChargeRequest.getSubscriptionId() != null) {
            chargeParams.put("subscription", stripeChargeRequest.getSubscriptionId());
        }
        try {
            Charge response = Charge.create(chargeParams);
            body = gsonConverter.convertChargeToMaps(response);
            if (null == body) {
                return falseAlert(body);
            }
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        return trueAlert(body);
    }
}
