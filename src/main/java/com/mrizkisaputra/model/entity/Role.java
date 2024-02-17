package com.mrizkisaputra.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;


@Entity(name = "s_roles")
public class Role implements GrantedAuthority {
    @Getter
    @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Setter
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ApplicationRole authority;

    @Override
    public String getAuthority() {
        return authority.name();
    }

    public Role() {
        super();
    }

    public Role(ApplicationRole authority) {
        super();
        this.authority = authority;
    }
}
