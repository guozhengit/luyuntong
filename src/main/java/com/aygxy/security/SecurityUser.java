package com.aygxy.security;



import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author
 */
public class SecurityUser implements UserDetails {

    private static final long serialVersionUID = -2991294278096491801L;

    @Getter
    private String id;

    @Getter
    private String name;

    @Getter
    private String email;

    @Getter
    private String phone;

    private String password;

    private boolean enabled;

    private boolean locked;

    public SecurityUser() {
    }

    public SecurityUser(String id, String name, String email, String phone, String password, boolean enabled, boolean locked) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.enabled = enabled;
        this.locked = locked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
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
