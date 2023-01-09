package com.headless.ecommerce.domain;

import javax.persistence.*;

@Entity(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "author")
    private Category category;
    private String clientId;
    private String externalUserId;
    private String anonymousId;
    private String customerId;
}
