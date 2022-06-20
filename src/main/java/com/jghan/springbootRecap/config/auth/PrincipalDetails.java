package com.jghan.springbootRecap.config.auth;

import com.jghan.springbootRecap.domain.user.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;
    private Map<String, Object> attributes;

    public PrincipalDetails(User user){
        this.user = user;
    }
    public PrincipalDetails(User user, Map<String, Object> attributes){
        this.user = user;
    }


    //권한이 1개가 이닐수 있어서 Collection타입
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collector = new ArrayList<>(); //ArrayList의 부모가 Collection
        collector.add(() -> { return user.getRole();});
        return collector;

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
        return true; //false면 로그인 안된다.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //false면 로그인 안된다.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //false면 로그인 안된다.
    }

    @Override
    public boolean isEnabled() {
        return true; //false면 로그인 안된다.
    }


}
