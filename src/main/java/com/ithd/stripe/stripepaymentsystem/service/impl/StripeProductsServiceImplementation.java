package com.ithd.stripe.stripepaymentsystem.service.impl;

import com.ithd.stripe.stripepaymentsystem.util.GsonConverter;
import com.ithd.stripe.stripepaymentsystem.exceptions.webexceptions.ObjectNullException;
import com.ithd.stripe.stripepaymentsystem.model.request.StripeProductsRequest;
import com.ithd.stripe.stripepaymentsystem.model.response.BaseApiStripeResponse;
import com.ithd.stripe.stripepaymentsystem.service.action.ProductAction;
import com.ithd.stripe.stripepaymentsystem.service.service.StripeProductService;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.stripe.model.ProductCollection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.falseAlert;
import static com.ithd.stripe.stripepaymentsystem.util.ResponseConverter.trueAlert;


@Service
@RequiredArgsConstructor
public class StripeProductsServiceImplementation implements StripeProductService, ProductAction {

    private final GsonConverter gsonConverter;

    /*
    product response section
     */
    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> create(StripeProductsRequest stripeProducts) throws StripeException {
        if (stripeProducts == null) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = creatAction(stripeProducts);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> findById(StripeProductsRequest stripeProductsRequest) throws StripeException {
        if (stripeProductsRequest == null) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = findByIdAction(stripeProductsRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> updateById(StripeProductsRequest stripeProductsRequest) throws StripeException {
        if (stripeProductsRequest == null) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = updateByIdAction(stripeProductsRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> finaAll(StripeProductsRequest stripeProductsRequest) throws StripeException {
        BaseApiStripeResponse<?> response = findAllAction(stripeProductsRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @Override
    public ResponseEntity<BaseApiStripeResponse<?>> deleteById(StripeProductsRequest stripeProductsRequest) throws StripeException {
        if (null == stripeProductsRequest) throw new ObjectNullException();
        BaseApiStripeResponse<?> response = deleteByIdAction(stripeProductsRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /*
    product Action section
     */
    @Override
    public BaseApiStripeResponse<?> deleteByIdAction(StripeProductsRequest stripeProductsRequest) throws StripeException {
        Product product = Product.retrieve(stripeProductsRequest.getId());
        Product deletedProduct = product.delete();
        Map<String, Object> body = gsonConverter.convertProductToMaps(deletedProduct);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);

    }

    @Override
    public BaseApiStripeResponse<?> findAllAction(StripeProductsRequest stripeProductsRequest) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        if (null == stripeProductsRequest.getLimit() || stripeProductsRequest.getLimit() == 0) {
            params.put("limit", 3);
        } else {
            params.put("limit", stripeProductsRequest.getLimit());
        }
        ProductCollection products = Product.list(params);
        Map<String, Object> body = gsonConverter.convertProductCollectionToMaps(products);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> updateByIdAction(StripeProductsRequest stripeProductsRequest) throws StripeException {
        Product productToUpdate = Product.retrieve(stripeProductsRequest.getId());
        //check metadata
        Map<String, Object> metaData = new HashMap<>();
        metaData.put("metadata", productToUpdate.getMetadata());

        Map<String, Object> params = new HashMap<>();
        params.put("description", stripeProductsRequest.getDescription());
        params.put("active", stripeProductsRequest.getActive());
        params.put("name", stripeProductsRequest.getName());
        params.put("images", stripeProductsRequest.getImages());
        params.put("attributes", stripeProductsRequest.getAttributes());
        params.put("metadata", metaData);

        Product updatedProduct = productToUpdate.update(params);
        Map<String, Object> body = gsonConverter.convertProductToMaps(updatedProduct);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> findByIdAction(StripeProductsRequest stripeProductsRequest) throws StripeException {
        Product product = Product.retrieve(stripeProductsRequest.getId());
        Map<String, Object> body = gsonConverter.convertProductToMaps(product);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }

    @Override
    public BaseApiStripeResponse<?> creatAction(StripeProductsRequest stripeProductsRequest) throws StripeException {
        Map<String, Object> productParam = new LinkedHashMap<>();
        productParam.put("name", stripeProductsRequest.getName());
        if (stripeProductsRequest.getDescription() != null) {
            productParam.put("description", stripeProductsRequest.getDescription());
        }
        productParam.put("active", stripeProductsRequest.getActive());
        if (stripeProductsRequest.getImages() != null) {
            productParam.put("images", stripeProductsRequest.getImages());
        }

        Product product = Product.create(productParam);
        Map<String, Object> body = gsonConverter.convertProductToMaps(product);
        if (null == product) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }


    //Product need to think about building it of products sold
    //if someone both this product must add in the metadata
    private BaseApiStripeResponse<?> updateByIdSoldAction(StripeProductsRequest stripeProductsRequest) throws StripeException {
        Product productToUpdate = Product.retrieve(stripeProductsRequest.getId());
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", stripeProductsRequest.getOrderID());
        Map<String, Object> params = new HashMap<>();
        params.put("metadata", metadata);
        Product updatedProduct = productToUpdate.update(params);
        Map<String, Object> body = gsonConverter.convertProductToMaps(updatedProduct);
        if (null == body) {
            return falseAlert(body);
        }
        return trueAlert(body);
    }
}
