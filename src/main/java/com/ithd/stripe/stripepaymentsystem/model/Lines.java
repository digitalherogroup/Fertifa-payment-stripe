package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Lines {

@SerializedName("data")
@Expose
public List<Datum> data = null;
@SerializedName("has_more")
@Expose
public Boolean hasMore;
@SerializedName("object")
@Expose
public String object;
@SerializedName("url")
@Expose
public String url;

}