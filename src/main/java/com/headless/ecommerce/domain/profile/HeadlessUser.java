package com.headless.ecommerce.domain.profile;

import java.util.List;

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
    private List<Address> address;

    @OneToMany
    @JoinColumn(referencedColumnName = "userId")
    private List<UserRole> userRole;

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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }
}
