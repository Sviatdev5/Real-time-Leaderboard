package com.lederboard.backend.security;

import com.lederboard.backend.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Ми беремо нашу роль (наприклад ROLE_USER) і перетворюємо на Authority
        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash(); // Віддаємо хеш пароля
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // Для нас логін — це пошта
    }

    // --- Стандартні налаштування (все дозволено) ---
    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
    
    // Додатковий метод, щоб дістати оригінального юзера, якщо треба
    public User getUser() {
        return user;
    }
}