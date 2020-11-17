package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stripe.model.Price;

import java.util.List;

public class Datum {

@SerializedName("id")
@Expose
public String id;
@SerializedName("object")
@Expose
public String object;
@SerializedName("amount")
@Expose
public Integer amount;
@SerializedName("currency")
@Expose
public String currency;
@SerializedName("description")
@Expose
public String description;
@SerializedName("discount_amounts")
@Expose
public List<Object> discountAmounts = null;
@SerializedName("discountable")
@Expose
public Boolean discountable;
@SerializedName("discounts")
@Expose
public List<Object> discounts = null;
@SerializedName("invoice_item")
@Expose
public String invoiceItem;
@SerializedName("livemode")
@Expose
public Boolean livemode;
@SerializedName("metadata")
@Expose
public MetaData metadata;
@SerializedName("period")
@Expose
public Period period;
@SerializedName("price")
@Expose
public Price price;
@SerializedName("proration")
@Expose
public Boolean proration;
@SerializedName("quantity")
@Expose
public Integer quantity;
@SerializedName("subscription")
@Expose
public Object subscription;
@SerializedName("tax_amounts")
@Expose
public List<Object> taxAmounts = null;
@SerializedName("tax_rates")
@Expose
public List<Object> taxRates = null;
@SerializedName("type")
@Expose
public String type;

}