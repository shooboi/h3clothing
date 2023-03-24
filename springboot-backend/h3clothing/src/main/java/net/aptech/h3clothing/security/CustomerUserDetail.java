package net.aptech.h3clothing.security;

import net.aptech.h3clothing.entity.Role;
import net.aptech.h3clothing.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerUserDetail implements UserDetails {

    User u;

    public CustomerUserDetail() {

    }

    CustomerUserDetail(User u) {
        this.u = u;
    }

    public User getUser() {
        return this.u;
    }

    public void setUser(User u) {
        this.u = u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : u.getRoleSet()) {
            authorities.add(new SimpleGrantedAuthority(role.getRollName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public String getUsername() {
        return u.getEmail();
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
        return true;
    }
}
