package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.Currency;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.SubscriptionAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeSubscriptionService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.Subscription;
import com.stripe.model.SubscriptionCollection;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.PRODUCT_DESCRIPTION;
import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.PRODUCT_NAME;
import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.SUBSCRIPTION_TRAIL;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;
import static com.ithd.stripe.stripepaymentsystem.util.StringConverter.covertErrorMessage;

@Service
@RequiredArgsConstructor
public class StripeSubscriptionImplementation implements StripeSubscriptionService, SubscriptionAction {

    private final GsonConverter gsonConverter;

    @Override
    @SneakyThrows
    public ResponseEntity<BaseApiStripeResponse<?>> create(
            StripeSubscriptionRequest stripeSubscriptionRequest) throws ObjectNullException {
        if (stripeSubscriptionRequest == null) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = creatAction(stripeSubscriptionRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }


    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> retrieve(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        if (stripeSubscriptionRequest == null) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = retrieveAction(stripeSubscriptionRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> delete(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        if (stripeSubscriptionRequest == null) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = deleteAction(stripeSubscriptionRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> findAll(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        BaseApiStripeResponse<?> response = findAllAction(stripeSubscriptionRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public BaseApiStripeResponse<?> creatAction(StripeSubscriptionRequest stripeSubscriptionRequest)
            throws StripeException {
        Map<String, Object> body = new HashMap<>();
        try {
            //Create products
            ProductCreateParams productCreateParams = ProductCreateParams.builder()
                    .setName(PRODUCT_NAME)
                    .setActive(true)
                    .setDescription(PRODUCT_DESCRIPTION)
                    .build();
            Product product = Product.create(productCreateParams);
            //create subscription price
            PriceCreateParams priceCreateParams =
                    PriceCreateParams.builder()
                            .setNickname(PRODUCT_NAME)
                            .setProduct(product.getId())
                            .setUnitAmount(stripeSubscriptionRequest.getPrice() * 100)
                            .setCurrency(String.valueOf(Currency.GBP))
                            .setRecurring(
                                    PriceCreateParams.Recurring.builder()
                                            .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                            .setTrialPeriodDays(SUBSCRIPTION_TRAIL)
                                            .build())
                            .build();

            Price price = Price.create(priceCreateParams);

            List<Object> items = new ArrayList<>();
            Map<String, Object> subMap = new HashMap<>();
            subMap.put("price", price.getId());
            items.add(subMap);
            Map<String, Object> subParams = new HashMap<>();
            subParams.put("customer", stripeSubscriptionRequest.getCustomerId());
            subParams.put("items", items);


            Subscription subscription = Subscription.create(subParams);
             body = gsonConverter.convertSubToMaps(subscription);
            if (null == body) {
                return falseAlert(body);
            }
        }catch (StripeException e){
            body.put("message", covertErrorMessage(e.getMessage()));
            falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> retrieveAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        Subscription subscription = Subscription.retrieve(stripeSubscriptionRequest.getSubscriptionId());
        Map<String, Object> body = gsonConverter.convertSubToMaps(subscription);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> deleteAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        Subscription subscription = Subscription.retrieve(stripeSubscriptionRequest.getSubscriptionId());
        Subscription deletedSubscription = subscription.cancel();
        Map<String, Object> body = gsonConverter.convertSubToMaps(deletedSubscription);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> findAllAction(StripeSubscriptionRequest stripeSubscriptionRequest) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        if(null == stripeSubscriptionRequest.getLimit() || stripeSubscriptionRequest.getLimit() == 0){
            params.put("limit", 3);
        }else {
            params.put("limit", stripeSubscriptionRequest.getLimit());
        }
        SubscriptionCollection subscriptions = Subscription.list(params);
        Map<String, Object> body = gsonConverter.convertSubToMaps(subscriptions);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

}
