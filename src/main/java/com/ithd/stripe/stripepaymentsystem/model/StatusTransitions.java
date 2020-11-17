package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusTransitions {

@SerializedName("finalized_at")
@Expose
public Object finalizedAt;
@SerializedName("marked_uncollectible_at")
@Expose
public Object markedUncollectibleAt;
@SerializedName("paid_at")
@Expose
public Object paidAt;
@SerializedName("voided_at")
@Expose
public Object voidedAt;

}