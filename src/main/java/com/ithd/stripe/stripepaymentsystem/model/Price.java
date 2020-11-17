package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

@SerializedName("id")
@Expose
public String id;
@SerializedName("object")
@Expose
public String object;
@SerializedName("active")
@Expose
public Boolean active;
@SerializedName("billing_scheme")
@Expose
public String billingScheme;
@SerializedName("created")
@Expose
public Integer created;
@SerializedName("currency")
@Expose
public String currency;
@SerializedName("livemode")
@Expose
public Boolean livemode;
@SerializedName("lookup_key")
@Expose
public Object lookupKey;
@SerializedName("metadata")
@Expose
public MetaData metadata;
@SerializedName("nickname")
@Expose
public Object nickname;
@SerializedName("product")
@Expose
public String product;
@SerializedName("recurring")
@Expose
public Object recurring;
@SerializedName("tiers_mode")
@Expose
public Object tiersMode;
@SerializedName("transform_quantity")
@Expose
public Object transformQuantity;
@SerializedName("type")
@Expose
public String type;
@SerializedName("unit_amount")
@Expose
public Integer unitAmount;
@SerializedName("unit_amount_decimal")
@Expose
public String unitAmountDecimal;

}