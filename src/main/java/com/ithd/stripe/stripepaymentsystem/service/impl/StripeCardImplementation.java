package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeCardRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.CardAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeCardService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.PaymentSourceCollection;
import com.stripe.model.Token;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.OBJECT_TYPE;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;
import static com.ithd.stripe.stripepaymentsystem.util.StringConverter.covertErrorMessage;

@Service
@RequiredArgsConstructor
public class StripeCardImplementation implements StripeCardService, CardAction {

    private final GsonConverter gsonConverter;

    @SneakyThrows
    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripeCardRequest stripeCardRequest) {
        if (null == stripeCardRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = createAction(stripeCardRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    @SneakyThrows
    public ResponseEntity<BaseApiStripeResponse<?>> delete(StripeCardRequest stripeCardRequest) {
        if (null == stripeCardRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = deleteAction(stripeCardRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> retrieve(StripeCardRequest stripeCardRequest) throws StripeException {
        if (null == stripeCardRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = retrieveAction(stripeCardRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> findAll(StripeCardRequest stripeCardRequest) throws StripeException {
        BaseApiStripeResponse<?> response = findAllAction(stripeCardRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    @SneakyThrows
    public BaseApiStripeResponse<?> createAction(StripeCardRequest stripeCardRequest) {
        Customer customer = null;
        Map<String, Object> body = new HashMap<>();
        try {
            customer = Customer.retrieve(stripeCardRequest.getCustomerId());
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        Map<String, Object> card = new HashMap<>();
        card.put("number", stripeCardRequest.getNumber());
        card.put("object", OBJECT_TYPE);
        card.put("exp_month", stripeCardRequest.getMonth());
        card.put("exp_year", stripeCardRequest.getYear());
        card.put("cvc", stripeCardRequest.getCvc());
        card.put("name", stripeCardRequest.getFirstName() + " " + stripeCardRequest.getLastName());

        Map<String, Object> tokenParam = new HashMap<>();
        tokenParam.put("card", card);

        try {
            Token token = Token.create(tokenParam);
            Map<String, Object> source = new HashMap<>();
            source.put("source", token.getId());
            customer.getSources().create(source);
            assert false;
            if (token.getLastResponse().code() >= 200 && token.getLastResponse().code() <= 299) {
                body = gsonConverter.convertTokenToMaps(token);
                return trueAlert(body);
            }
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        return falseAlert(body);
    }


    @Override
    @SneakyThrows
    public BaseApiStripeResponse<?> deleteAction(StripeCardRequest stripeCardRequest) {
        Map<String, Object> body = new HashMap<>();
        Card deletedCard = null;
        if (null == stripeCardRequest) throw new ObjectNullException();
        Customer customer = Customer.retrieve(stripeCardRequest.getCustomerId());
        if (customer == null) throw new ObjectNullException();
        try {
            Card card = (Card) customer.getSources().retrieve(stripeCardRequest.getCardId());
            deletedCard = card.delete();
            body = gsonConverter.convertCardToMaps(deletedCard);

        } catch (Exception e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        if (deletedCard == null) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> retrieveAction(StripeCardRequest stripeCardRequest) throws StripeException {
        Customer customer = Customer.retrieve(stripeCardRequest.getCustomerId());
        Card card = (Card) customer.getSources().retrieve(stripeCardRequest.getCardId());
        Map<String, Object> body = gsonConverter.convertCardToMaps(card);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> findAllAction(StripeCardRequest stripeCardRequest) throws StripeException {
        Customer customer = Customer.retrieve(stripeCardRequest.getCustomerId());
        Map<String, Object> params = new HashMap<>();
        params.put("object", "card");
        params.put("limit", 10);
        PaymentSourceCollection cards =customer.getSources().list(params);
        Map<String,Object> body = gsonConverter.convertCardToMaps(cards);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }
}
