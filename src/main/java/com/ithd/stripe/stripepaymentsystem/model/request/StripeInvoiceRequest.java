package com.ithd.stripe.stripepaymentsystem.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeInvoiceRequest {
    @SerializedName("customerId")
    @Expose
    private String customerId;
    @SerializedName("price")
    @Expose
    private String price;
}
