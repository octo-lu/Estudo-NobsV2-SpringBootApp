package com.example.nobsv2.product.validators;

import com.example.nobsv2.exceptions.ErrorMesages;
import com.example.nobsv2.exceptions.ProductNotValidException;
import com.example.nobsv2.product.model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {

    private ProductValidator(){

    }

    public static void execute(Product product){

            if(StringUtils.isEmpty(product.getName())){
                throw new ProductNotValidException(ErrorMesages.NAME_REQUIRED.getMessage());
            }

            if(product.getDescription().length() < 20){
                throw new ProductNotValidException(ErrorMesages.DESCRIPTION_LENGHT.getMessage());
            }

            if(product.getPrice() == null || product.getPrice() < 0.00){
                throw new ProductNotValidException(ErrorMesages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
            }
    }
}

