package com.basic.myspringboot.security.config;

import com.basic.myspringboot.security.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetails implements UserDetails {

    private String email;
    private String password;
    private List<GrantedAuthority> authorities;
    private UserInfo userInfo;

    public UserInfoUserDetails(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.email=userInfo.getEmail();
        this.password=userInfo.getPassword();
        //[ROLE_ADMIN, ROLE_USER]
        this.authorities= Arrays.stream(userInfo.getRoles().split(","))
                //.map(SimpleGrantedAuthority::new)
                .map(roleName -> new SimpleGrantedAuthority(roleName))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    //getPassword() 와 getUsername() 메서드는
    /*
       getPassword() 와 getUsername() 메서드는
       실제로 인증을 처리하는 AuthenticationManager가 인증을 처리할 때
       사용합니다.
     */
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
    
    public UserInfo getUserInfo() {
        return userInfo;
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