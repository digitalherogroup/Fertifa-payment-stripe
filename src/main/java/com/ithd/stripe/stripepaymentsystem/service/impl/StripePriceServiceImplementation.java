package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripePriceRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.PriceAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripePriceService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.PriceCollection;
import com.stripe.param.PriceCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;

@Service
@RequiredArgsConstructor
public class StripePriceServiceImplementation implements StripePriceService, PriceAction {

    private final GsonConverter gsonConverter;

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripePriceRequest stripePriceRequest) throws StripeException {
        if (null == stripePriceRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = creatAction(stripePriceRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> findById(StripePriceRequest stripePriceRequest) throws StripeException {
        if (null == stripePriceRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = findByIdAction(stripePriceRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> findAll(StripePriceRequest stripePrice) throws StripeException {
        BaseApiStripeResponse<?> response = findAllAction(stripePrice);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public BaseApiStripeResponse<?> creatAction(StripePriceRequest stripePrice) throws StripeException {
        PriceCreateParams priceCreateParams = PriceCreateParams.builder()
                .setProduct(stripePrice.getProductId())
                .setUnitAmount(stripePrice.getPrice())
                .setCurrency("gbp")
                .setNickname(stripePrice.getUserId())
                .build();
        Price price = Price.create(priceCreateParams);
        Map<String, Object> body = gsonConverter.convertPriceToMaps(price);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> findByIdAction(StripePriceRequest stripePrice) throws StripeException {
        Price price = Price.retrieve(stripePrice.getId());
        Map<String, Object> body = gsonConverter.convertPriceToMaps(price);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> findAllAction(StripePriceRequest stripePrice) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        if (null == stripePrice.getLimit() || stripePrice.getLimit() == 0) {
            params.put("limit", 3);
        } else {
            params.put("limit", stripePrice.getLimit());
        }
        PriceCollection prices = Price.list(params);
        Map<String, Object> body = gsonConverter.convertPriceToMaps(prices);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

}
