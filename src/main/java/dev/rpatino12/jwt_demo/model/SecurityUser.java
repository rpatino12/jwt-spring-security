package dev.rpatino12.jwt_demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
/**
 * Instead of polluting my User entity and having all these security details in the database, we split the
 * security details in a separate class that implements the UserDetails interface and satisfies Spring Security needs
 * to authenticate a User from JPA using the UserDetailsService.
 *
 * In JpaUserDetailsService we map the User entity to SecurityUser and authenticate with Spring Security.
 * */
public class SecurityUser implements UserDetails {

    private User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user
                .getRoles()
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
