package com.headless.ecommerce.domain.profile;

import javax.persistence.*;

@Entity(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "roleId")
    private Long roleId;

    @Column
    private Long userId;

    @Column
    private String name;

    @Column
    private String description;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
