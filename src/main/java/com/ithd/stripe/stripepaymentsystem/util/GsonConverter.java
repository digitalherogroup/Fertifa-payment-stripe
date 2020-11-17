package com.ithd.stripe.stripepaymentsystem.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Coupon;
import com.stripe.model.CouponCollection;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.model.Invoice;
import com.stripe.model.PaymentSourceCollection;
import com.stripe.model.Price;
import com.stripe.model.PriceCollection;
import com.stripe.model.Product;
import com.stripe.model.ProductCollection;
import com.stripe.model.Subscription;
import com.stripe.model.SubscriptionCollection;
import com.stripe.model.Token;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Map;

@Component
public class GsonConverter {

  public Map<String, Object> convertProductToMaps(Product t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertProductCollectionToMaps(ProductCollection t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertPriceToMaps(Price t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertPriceToMaps(PriceCollection t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertCustomerToMaps(Customer t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertCustomerToMaps(CustomerCollection t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertCardToMaps(Card t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertCardToMaps(PaymentSourceCollection t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertTokenToMaps(Token t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertSubToMaps(Subscription t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertSubToMaps(SubscriptionCollection t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertCouponToMaps(Coupon t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertCouponToMaps(CouponCollection t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertChargeToMaps(Charge t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

  public Map<String, Object> convertInvoieToMap(Invoice t) {
    String responseJson = new Gson().toJson(t);
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    return new Gson().fromJson(responseJson, type);
  }

    public Map<String, Object> convertToMapObject(Object t) {
      String responseJson = new Gson().toJson(t);
      Type type = new TypeToken<Map<String, Object>>() {}.getType();
      return new Gson().fromJson(responseJson, type);
    }
}
