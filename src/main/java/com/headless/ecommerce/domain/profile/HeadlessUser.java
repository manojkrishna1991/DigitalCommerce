package com.headless.ecommerce.domain.profile;

import javax.persistence.*;

@Entity(name = "user")
public class HeadlessUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId ;

    @Column
    private String name;

    @Column
    private String password;

    @OneToMany
    @JoinColumn(referencedColumnName = "userId")
    private Address address;

    @OneToMany
    @JoinColumn(referencedColumnName = "userId")
    private UserRole userRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
