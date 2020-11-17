package com.ithd.stripe.stripepaymentsystem.exceptions;

import com.ithd.stripe.stripepaymentsystem.exceptions.stripeexceptions.stripeErrorHandling;
import com.ithd.stripe.stripepaymentsystem.exceptions.stripeexceptions.stripeExceptionHandling;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(stripeErrorHandling.class)
    public ResponseEntity<String> StripeErrorHandling(stripeErrorHandling stripeErrorHandling) {
        return new ResponseEntity<>(stripeErrorHandling.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(stripeExceptionHandling.class)
    public ResponseEntity<String> StripeExceptionHandling(stripeExceptionHandling stripeExceptionHandling) {
        return new ResponseEntity<>(stripeExceptionHandling.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<String> StripeExceptionHandling(ProductIdNotFoundException productIdNotFoundException) {
        return new ResponseEntity<>(productIdNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoProductNameException.class)
    public ResponseEntity<String> StripeProductNullException(NoProductNameException noProductNameException) {
        return new ResponseEntity<>(noProductNameException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotIncludedException.class)
    public ResponseEntity<String> ProductIdNull(IdNotIncludedException idNotIncludedException) {
        return new ResponseEntity<>(idNotIncludedException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductServiceException.class)
    public ResponseEntity<String> ProductIdNull(ProductServiceException productServiceException) {
        return new ResponseEntity<>(productServiceException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<String> ProductIdNull(AddressNotFoundException addressNotFoundException) {
        return new ResponseEntity<>(addressNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}