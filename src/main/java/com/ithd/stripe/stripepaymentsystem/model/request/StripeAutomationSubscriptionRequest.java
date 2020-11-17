package com.ithd.stripe.stripepaymentsystem.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StripeAutomationSubscriptionRequest {
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    //address
    @SerializedName("address1")
    @Expose
    private String address1;

    @SerializedName("address2")
    @Expose
    private String address2;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("state")
    @Expose
    private String state;

    //card
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("cardId")
    @Expose
    private String cardId;
    @SerializedName("cvc")
    @Expose
    private String cvc;
    @SerializedName("last4Digits")
    @Expose
    private String last4Digits;
    @SerializedName("createdDate")
    @Expose
    private Timestamp createdDate;
    @SerializedName("updatedDate")
    @Expose
    private Timestamp updatedDate;
    @SerializedName("cardType")
    @Expose
    private String cardType;
    @SerializedName("year")
    @Expose
    private Long year;
    @SerializedName("month")
    @Expose
    private Long month;

    //subscription
    @SerializedName("price")
    @Expose
    private Long price;
}
