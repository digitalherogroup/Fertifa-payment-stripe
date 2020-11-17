package com.ithd.stripe.stripepaymentsystem.model.response;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseApiStripeResponse<T> {
    private Timestamp date = new Timestamp(new Date().getTime());
    private boolean status;
    private int code;
    private T data;
}
