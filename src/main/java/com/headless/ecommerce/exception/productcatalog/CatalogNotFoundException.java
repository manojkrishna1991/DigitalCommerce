package com.headless.ecommerce.exception.productcatalog;

import com.headless.ecommerce.exception.NotFoundException;

public class CatalogNotFoundException extends NotFoundException {
    public CatalogNotFoundException() {
        super("catalog not found exception");
    }
}
