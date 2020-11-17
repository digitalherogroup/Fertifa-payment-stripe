package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
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
    @SerializedName("customer")
    @Expose
    public String customer;
    @SerializedName("date")
    @Expose
    public Integer date;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("discountable")
    @Expose
    public Boolean discountable;
    @SerializedName("discounts")
    @Expose
    public List<Object> discounts = null;
    @SerializedName("invoice")
    @Expose
    public Object invoice;
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
    public String price;
    @SerializedName("proration")
    @Expose
    public Boolean proration;
    @SerializedName("quantity")
    @Expose
    public Integer quantity;
    @SerializedName("subscription")
    @Expose
    public Object subscription;
    @SerializedName("tax_rates")
    @Expose
    public List<Object> taxRates = null;
    @SerializedName("unit_amount")
    @Expose
    public Integer unitAmount;
    @SerializedName("unit_amount_decimal")
    @Expose
    public String unitAmountDecimal;
}
