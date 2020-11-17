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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StripeCouponRequest{
    @SerializedName("id")
    @Expose
    private String Id;

    @SerializedName("percentageOff")
    @Expose
    private Long percentageOff;

    @SerializedName("limit")
    @Expose
    private Integer limit;
}
