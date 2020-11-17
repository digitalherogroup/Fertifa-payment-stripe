package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.Currency;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeAutomationSubscriptionRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.AutomationSubscriptionAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeAutomationSubscriptionService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Invoice;
import com.stripe.model.PaymentSource;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.Subscription;
import com.stripe.model.Token;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.SubscriptionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.OBJECT_TYPE;
import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.PRODUCT_NAME;
import static com.ithd.stripe.stripepaymentsystem.constances.StripeConstance.SUBSCRIPTION_TRAIL;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;
import static com.ithd.stripe.stripepaymentsystem.util.StringConverter.covertErrorMessage;

@Service
@RequiredArgsConstructor
public class StripeAutomationSubscriptionServiceImplementation
        implements StripeAutomationSubscriptionService, AutomationSubscriptionAction {

    private final GsonConverter gsonConverter;

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripeAutomationSubscriptionRequest ccs) throws StripeException {
        if (null == ccs) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = createAction(ccs);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public BaseApiStripeResponse<?> createAction(StripeAutomationSubscriptionRequest ccs) throws StripeException {
        Map<String, Object> body = new HashMap<>();
        Customer customer = CreateCustomer(ccs);
        try {
            if (null != customer.getId()) {
                if (null != CreateCard(ccs, customer)) {
                    Subscription subscription = CreateSubscription(ccs,customer);
                    Invoice invoice =Invoice.retrieve(subscription.getLatestInvoice());
                    System.out.println();
                    body = gsonConverter.convertSubToMaps(subscription);
                    if (body == null) {
                        return falseAlert(body);
                    }
                    assert false;
                    body.put("invoiceLink",invoice.getHostedInvoiceUrl());
                    return trueAlert(body);
                }
            }
        }catch (StripeException e){
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        body.put("message","something went wrong, please contact administration.");
        return falseAlert(body);
    }

    private PaymentSource CreateCard(StripeAutomationSubscriptionRequest ccs, Customer customer) throws StripeException {
        customer = Customer.retrieve(customer.getId());
        Map<String, Object> card = new HashMap<>();
        card.put("number", ccs.getNumber());
        card.put("object", OBJECT_TYPE);
        card.put("exp_month", ccs.getMonth());
        card.put("exp_year", ccs.getYear());
        card.put("cvc", ccs.getCvc());
        card.put("name", ccs.getFirstName() + " " + ccs.getLastName());

        Map<String, Object> tokenParam = new HashMap<>();
        tokenParam.put("card", card);

        Token token = Token.create(tokenParam);
        Map<String, Object> source = new HashMap<>();
        source.put("source", token.getId());
        return customer.getSources().create(source);

    }

    //Create subscription and charge
    private Subscription CreateSubscription(StripeAutomationSubscriptionRequest ccs, Customer customer) throws StripeException {
        if (ccs == null) throw new ObjectNullException();
        ProductCreateParams productCreateParams =
                ProductCreateParams.builder()
                        .setName(PRODUCT_NAME)
                        .setType(ProductCreateParams.Type.SERVICE)
                        .build();

        Product product = Product.create(productCreateParams);
        System.out.println();

        if (product == null) throw new ObjectNullException();

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setNickname(PRODUCT_NAME)
                        .setProduct(product.getId())
                        .setUnitAmount(ccs.getPrice() * 100)
                        .setCurrency(String.valueOf(Currency.GBP))
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .setTrialPeriodDays(SUBSCRIPTION_TRAIL)
                                        .build())
                        .build();

        Price price = Price.create(priceCreateParams);
        System.out.println();

        if (price == null) throw new ObjectNullException();

        Customer retrieveCustomer = Customer.retrieve(customer.getId());

        if (retrieveCustomer == null) throw new ObjectNullException();
        SubscriptionCreateParams params =
                SubscriptionCreateParams.builder()
                        .setCustomer(customer.getId())
                        .addItem(
                                SubscriptionCreateParams.Item.builder()
                                        .setPrice(price.getId())
                                        .build())
                        .build();

        Subscription subscription = Subscription.create(params);
        System.out.println();

        return subscription;
    }

    //Create Customer
    private Customer CreateCustomer(StripeAutomationSubscriptionRequest ccs) throws StripeException {
        CustomerCreateParams.Address customerCreateParamsAddress =
                CustomerCreateParams.Address.builder()
                        .setLine1(ccs.getAddress1())
                        .setLine2(ccs.getAddress2())
                        .setPostalCode(ccs.getPostalCode())
                        .setCity(ccs.getCity())
                        .setState(ccs.getState())
                        .setCountry(ccs.getCountry())
                        .build();
        CustomerCreateParams customerCreateParams =
                CustomerCreateParams.builder()
                        .setName(
                                ccs.getFirstName() + " " + ccs.getLastName())
                        .setEmail(ccs.getEmail())
                        .setPhone(ccs.getPhoneNumber())
                        .setAddress(customerCreateParamsAddress)
                        .build();
        return Customer.create(customerCreateParams);
    }
}
