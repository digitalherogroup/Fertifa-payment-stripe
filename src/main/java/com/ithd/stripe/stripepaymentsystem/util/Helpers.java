package com.ithd.stripe.stripepaymentsystem.util;

import java.util.Date;
import java.sql.Timestamp;

public class Helpers {
    public static Timestamp getTime() {
        return new Timestamp(new Date().getTime());
    }
}
