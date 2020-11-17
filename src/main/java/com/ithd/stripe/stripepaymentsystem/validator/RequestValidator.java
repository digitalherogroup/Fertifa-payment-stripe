package com.ithd.stripe.stripepaymentsystem.validator;

import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    @SneakyThrows
    public void validate(Object o) {
        if (o == null) throw new ObjectNullException();
    }
}
