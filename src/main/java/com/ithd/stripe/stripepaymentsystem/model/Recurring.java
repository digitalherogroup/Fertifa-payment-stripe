package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recurring {
    @SerializedName("aggregate_usage")
    @Expose
    public Object aggregateUsage;
    @SerializedName("interval")
    @Expose
    public String interval;
    @SerializedName("interval_count")
    @Expose
    public Integer intervalCount;
    @SerializedName("usage_type")
    @Expose
    public String usageType;
}
