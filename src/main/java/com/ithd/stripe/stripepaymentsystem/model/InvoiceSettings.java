package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceSettings {
    @SerializedName("custom_fields")
    @Expose
    public Object customFields;
    @SerializedName("default_payment_method")
    @Expose
    public Object defaultPaymentMethod;
    @SerializedName("footer")
    @Expose
    public Object footer;
}
