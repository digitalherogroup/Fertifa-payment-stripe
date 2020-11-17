package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerAddress {

@SerializedName("city")
@Expose
public String city;
@SerializedName("country")
@Expose
public String country;
@SerializedName("line1")
@Expose
public String line1;
@SerializedName("line2")
@Expose
public Object line2;
@SerializedName("postal_code")
@Expose
public String postalCode;
@SerializedName("state")
@Expose
public Object state;

}