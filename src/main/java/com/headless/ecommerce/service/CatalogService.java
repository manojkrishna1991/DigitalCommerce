package com.headless.ecommerce.service;

import com.headless.ecommerce.domain.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Catalog createCatalog(Catalog catalog) {

        return mongoTemplate.save(catalog);
    }

    public Catalog getCatalog(@NonNull String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Catalog.class);
    }
}
