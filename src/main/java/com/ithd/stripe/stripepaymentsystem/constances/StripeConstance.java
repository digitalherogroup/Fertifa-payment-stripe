package com.ithd.stripe.stripepaymentsystem.constances;

public class StripeConstance {
  public static final String API_KEY = "sk_test_mrUdKEQxFEvlaaWiVHYOPNAC00dV2p8tqq"; // testing key
  // public static final String API_KEY = "sk_test_YX7bTlyJ7TceAndm1rm28C3U00ffWEMxw0";//fertifa key
  // public static final String PUBLISHABLE_KEY  = "pk_test_ubokk6AJhwslKb85woLyMZkR004crVryCo";
  public static final String PUBLISHABLE_KEY = "pk_live_LmCPdantXSjD2xtwHZou48gr00FBX3fGsT";
  public static final String OBJECT_TYPE = "card";

  // price section
  public static final String PRODUCT_DESCRIPTION =
      "Monthly subscription to get access for fertifa benefits employee section";
  public static final String PRODUCT_TYPE = "service";
  public static final String PRODUCT_NAME = "Subscription for fertifa";

  // Subscription
  public static final Long SUBSCRIPTION_TRAIL = 3L;

  //Charge Messages
  public static final String DEFAULT_CHARGE_MESSAGE = "From shopping card of fertifa";
}
