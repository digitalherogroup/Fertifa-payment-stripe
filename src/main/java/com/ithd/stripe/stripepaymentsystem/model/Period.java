package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Period {

@SerializedName("end")
@Expose
public Integer end;
@SerializedName("start")
@Expose
public Integer start;

}
