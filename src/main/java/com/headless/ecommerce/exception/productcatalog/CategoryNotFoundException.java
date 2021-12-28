package com.headless.ecommerce.exception.productcatalog;

import com.headless.ecommerce.exception.NotFoundException;

public class CategoryNotFoundException extends NotFoundException {
    public CategoryNotFoundException() {
        super("category not found exception");
    }
}
