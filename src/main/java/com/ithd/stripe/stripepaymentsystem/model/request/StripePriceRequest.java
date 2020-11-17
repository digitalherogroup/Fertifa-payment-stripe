package com.ithd.stripe.stripepaymentsystem.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ithd.stripe.stripepaymentsystem.model.MetaData;
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
public class StripePriceRequest  {
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("productId")
    @Expose
    public String productId;
    @SerializedName("priceId")
    @Expose
    public String priceId;
    @SerializedName("price")
    @Expose
    public long price;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("active")
    @Expose
    public Boolean active;
    @SerializedName("billingScheme")
    @Expose
    public String billingScheme;
    @SerializedName("created")
    @Expose
    public Integer created;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("livemode")
    @Expose
    public Boolean livemode;
    @SerializedName("lookup_key")
    @Expose
    public Object lookupKey;
    @SerializedName("metadata")
    @Expose
    public MetaData metadata;
    @SerializedName("nickname")
    @Expose
    public Object nickname;
    @SerializedName("product")
    @Expose
    public String product;

    @SerializedName("tiersMode")
    @Expose
    public Object tiersMode;
    @SerializedName("transformQuantity")
    @Expose
    public Object transformQuantity;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("unitAmount")
    @Expose
    public Integer unitAmount;
    @SerializedName("unitAmountDecimal")
    @Expose
    public String unitAmountDecimal;
    @SerializedName("userId")
    @Expose
    public String userId;
}
