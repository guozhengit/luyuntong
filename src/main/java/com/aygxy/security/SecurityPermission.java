package com.aygxy.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author
 */
public class SecurityPermission implements GrantedAuthority {

    private static final long serialVersionUID = 5358454358906386858L;

    private String domain;

    private String permission;

    public SecurityPermission(String domain, String permission) {
        this.domain = domain.toUpperCase();
        this.permission = permission.toUpperCase();
    }

    @Override
    public String getAuthority() {
        return String.format("%s_%s", domain, permission);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SecurityPermission that = (SecurityPermission) o;

        return domain.equals(that.domain) && permission.equals(that.permission);
    }

    @Override
    public int hashCode() {
        int result = domain.hashCode();
        result = 31 * result + permission.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
