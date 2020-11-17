package com.ithd.stripe.stripepaymentsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sources {
    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("data")
    @Expose
    public List<Object> data = null;
    @SerializedName("has_more")
    @Expose
    public Boolean hasMore;
    @SerializedName("url")
    @Expose
    public String url;
}
