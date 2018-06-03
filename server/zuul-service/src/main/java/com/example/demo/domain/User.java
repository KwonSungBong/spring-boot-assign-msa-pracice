package com.example.demo.domain;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String authorities;

    @NotNull
    private Boolean enabled = false;

//    @NotNull
    private String name;

//    @NotNull
    private String gender;

//    @NotNull
    private Date birth;

    private String address;

    private String interest;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}