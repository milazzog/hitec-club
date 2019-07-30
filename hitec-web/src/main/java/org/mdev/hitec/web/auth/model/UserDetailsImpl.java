package org.mdev.hitec.web.auth.model;

import org.apache.commons.collections4.CollectionUtils;
import org.mdev.hitec.persistence.core.model.Permission;
import org.mdev.hitec.persistence.core.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by GiuseppeMilazzo on 30/07/2019.
 */
public class UserDetailsImpl implements UserDetails {

    public static final String ROLE_PREFIX = "ROLE_";

    private User user;
    private Set<GrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.user = user;
        initAuthorities(user.getPermissions());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.isActive();
    }

    public User getUser() {
        return user;
    }

    private void initAuthorities(Set<Permission> permissions) {

        this.authorities = CollectionUtils.isNotEmpty(permissions) ? permissions
                .stream()
                .map(p -> (GrantedAuthority) () -> String.format("%s%s", ROLE_PREFIX, p.getPermissionType().name()))
                .collect(Collectors.toSet()) : new HashSet<>();
    }
}