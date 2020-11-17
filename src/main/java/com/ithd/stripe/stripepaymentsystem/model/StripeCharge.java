package com.ithd.stripe.stripepaymentsystem.model;

import com.ithd.stripe.stripepaymentsystem.model.request.StripeCustomerRequest;
import com.stripe.model.Charge;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StripeCharge<T> extends Charge {

    private String message;
    private String stripeEmail;
    private String stripeToken;
    private Timestamp created_Date;
    private String code;
    private String StripeSubscription_id;
    private String customer_id;
    private String card_id;
    private String number;
    private String card_Id;
    private StripeCustomerRequest address;
    private String cvc;
    private String firstName;
    private String lastName;
    private Long exp_month;
    private Long exp_year;
    private StripeCustomerRequest users;
    private Timestamp created_date;
    private String card_type;
    private String Last4;
    private HttpStatus codes;


    public StripeCharge(boolean b, String s, int i, Charge charging) {
    }
}