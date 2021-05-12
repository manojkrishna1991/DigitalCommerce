package com.headless.ecommerce.generator;

import com.headless.ecommerce.domain.IdGenerator;
import com.headless.ecommerce.repository.IdGeneratorRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * This class is used to generate product id
 * @author Manoj Krishna
 */
@Component
public class ProductIdGeneratorComponent implements IdGeneratorComponent, InitializingBean {
    @Value("${productGenerator.name}")
    private String name;
    @Value("${productGenerator.seedId}")
    private Long seedId;
    private Long currentId;
    @Value("${productGenerator.batchSize}")
    private Long batchSize;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Long generateId() {
        Long currentId = getCurrentId();
        currentId++;
        setCurrentId(currentId);
        updateIdGenerator(currentId);
        return currentId;
    }

    private Query findQuery() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return query;
    }

    @Override
    public String generateIdInString() {
        return getCurrentId().toString();
    }


    @Override
    public void afterPropertiesSet() {
        IdGenerator idGenerator = mongoTemplate.findOne(findQuery(), IdGenerator.class);
        if (idGenerator == null) {
            setCurrentId(seedId);
            IdGenerator newIdGenerator = new IdGenerator(name, batchSize, seedId);
            mongoTemplate.save(newIdGenerator);
        } else {
            Long seedId = idGenerator.getSeed();
            Long newSeedId = seedId + 1L;
            setCurrentId(newSeedId);
            updateIdGenerator(currentId);
        }
    }

    private void updateIdGenerator(Long currentId) {
        Update update = new Update();
        update.set("seed", currentId);
        mongoTemplate.updateFirst(findQuery(), update, IdGenerator.class);
    }

    public Long getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Long currentId) {
        this.currentId = currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeedId() {
        return seedId;
    }

    public void setSeedId(Long seedId) {
        this.seedId = seedId;
    }

    public Long getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Long batchSize) {
        this.batchSize = batchSize;
    }
}
