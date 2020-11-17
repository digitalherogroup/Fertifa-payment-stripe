package com.ithd.stripe.stripepaymentsystem.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stripe.model.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StripeSubscriptionRequest  {
    @SerializedName("priceId")
    @Expose
    private String priceId;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("subscriptionId")
    @Expose
    private String subscriptionId;
    @SerializedName("price")
    @Expose
    private Long price;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("billingCycle")
    @Expose
    private Long billingCycle;
    @SerializedName("paymentCycle")
    @Expose
    private String paymentCycle;
    @SerializedName("nextPaymentDate")
    @Expose
    private Long nextPaymentDate;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("latestInvoice")
    @Expose
    private String latestInvoice;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("trailPeriod")
    @Expose
    private Long trailPeriod;
    @SerializedName("stripeBalance")
    @Expose
    private Long stripeBalance;
    @SerializedName("endsAt")
    @Expose
    private Long endsAt;
    @SerializedName("plan")
    @Expose
    private Plan plan;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("creationDate")
    @Expose
    private Timestamp creationDate;
    @SerializedName("update_date")
    @Expose
    private Timestamp updateDate;
    @SerializedName("lastLoginDate")
    @Expose
    private Timestamp lastLoginDate;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("customerId")
    @Expose
    private String customerId;
}
