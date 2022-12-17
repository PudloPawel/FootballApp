package com.example.footballapp.models.userDetails;

import com.example.footballapp.security.permission.ApplicationUserRole;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private final String login;
    private final String password;
    private final ApplicationUserRole role;
    private final String secretKey;

    @NonNull
    private final long id;

    @Builder
    public CustomUserDetails(String login,
                             String password,
                             ApplicationUserRole role,
                             String secretKey,
                             long id) {
        this.login = login;
        this.password = password;
        this.role = Optional.ofNullable(role)
                .orElse(ApplicationUserRole.USER);
        this.secretKey = secretKey;
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> roles = Sets.newHashSet();

        roles.addAll(role.getGrantedAuthorities());

        roles.add(new SimpleGrantedAuthority("ROLE"+role.name()));

        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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
