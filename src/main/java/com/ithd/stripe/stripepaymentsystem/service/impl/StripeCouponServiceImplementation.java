package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeCouponRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.CouponAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeCouponService;
import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.stripe.exception.StripeException;
import com.stripe.model.Coupon;
import com.stripe.model.CouponCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;
import static com.ithd.stripe.stripepaymentsystem.util.StringConverter.covertErrorMessage;

@Service
@RequiredArgsConstructor
public class StripeCouponServiceImplementation implements StripeCouponService, CouponAction {

    private final GsonConverter gsonConverter;

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripeCouponRequest stripeCouponRequest) throws StripeException {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = createAction(stripeCouponRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }


    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> retrieve(StripeCouponRequest stripeCouponRequest) {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = retrieveAction(stripeCouponRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> deleteById(StripeCouponRequest stripeCouponRequest) {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = deleteByIdAction(stripeCouponRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> findAll(StripeCouponRequest stripeCouponRequest) {
        if (null == stripeCouponRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = findAllAction(stripeCouponRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public BaseApiStripeResponse<?> findAllAction(StripeCouponRequest stripeCouponRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, Object> params = new HashMap<>();

        if (null == stripeCouponRequest.getLimit() || stripeCouponRequest.getLimit() == 0) {
            params.put("limit", 3);
        } else {
            params.put("limit", stripeCouponRequest.getLimit());
        }
        try {
            CouponCollection coupons = Coupon.list(params);
            body = gsonConverter.convertCouponToMaps(coupons);
            if (null == body) {
                return falseAlert(body);
            }
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> createAction(StripeCouponRequest stripeCouponRequest) {
        Map<String, Object> body = new HashMap<>();
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("percent_off", stripeCouponRequest.getPercentageOff());
            params.put("duration", "once");
            Coupon coupon = Coupon.create(params);
            body = gsonConverter.convertCouponToMaps(coupon);
            if (null == body) {
                return falseAlert(body);
            }
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> retrieveAction(StripeCouponRequest stripeCouponRequest) {
        Map<String, Object> body = new HashMap<>();
        try {
            Coupon coupon = Coupon.retrieve(stripeCouponRequest.getId());
            body = gsonConverter.convertCouponToMaps(coupon);
            if (null == body) {
                return falseAlert(body);
            }
        } catch (StripeException e) {
            body.put("message", covertErrorMessage(e.getMessage()));
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> deleteByIdAction(StripeCouponRequest stripeCouponRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        try {
            Coupon coupon = Coupon.retrieve(stripeCouponRequest.getId());

            Coupon deletedCoupon = coupon.delete();
            body = gsonConverter.convertCouponToMaps(deletedCoupon);
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
