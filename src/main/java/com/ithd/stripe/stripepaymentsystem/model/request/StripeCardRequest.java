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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StripeCardRequest{

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
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("customerId")
    @Expose
    private String customerId;

}