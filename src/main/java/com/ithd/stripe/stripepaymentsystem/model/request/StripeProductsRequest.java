package com.ithd.stripe.stripepaymentsystem.model.request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ithd.stripe.stripepaymentsystem.model.MetaData;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeProductsRequest {
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("active")
    @Expose
    public Boolean active;
    @SerializedName("orderID")
    @Expose
    public String orderID;
    @SerializedName("attributes")
    @Expose
    public List<String> attributes = null;
    @SerializedName("caption")
    @Expose
    public String caption;
    @SerializedName("created")
    @Expose
    public Integer created;
    @SerializedName("deactivateOn")
    @Expose
    public String deactivateOn;
    @SerializedName("deleted")
    @Expose
    public String deleted;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("images")
    @Expose
    public List<String> images = null;
    @SerializedName("livemode")
    @Expose
    public Boolean livemode;
    @SerializedName("metadata")
    @Expose
    public MetaData metadata;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("packageDimensions")
    @Expose
    public Object packageDimensions;
    @SerializedName("shippable")
    @Expose
    public Object shippable;
    @SerializedName("statementDescriptor")
    @Expose
    public String statementDescriptor;
    @SerializedName("unit_label")
    @Expose
    public String unitLabel;
    @SerializedName("updated")
    @Expose
    public Integer updated;
    @SerializedName("url")
    @Expose
    public Object url;
    @SerializedName("type")
    @Expose
    public String type;
}


