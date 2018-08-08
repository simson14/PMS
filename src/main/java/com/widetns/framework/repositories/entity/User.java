package com.widetns.framework.repositories.entity;

import lombok.Getter;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "UserInfo")
@Getter
@Setter
public class User extends AbstractEntity {

    @Id
    @NotEmpty
    @Email
    @Size(max = 255)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 4, max = 255)
    private String passwordHash;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String role;

    private boolean locked = false;

    @PrePersist
    @PreUpdate
    private void prepareData() {
        this.email = email == null ? null : email.toLowerCase();
    }

    public User() {
        // An empty constructor is needed for all beans
    }
}
