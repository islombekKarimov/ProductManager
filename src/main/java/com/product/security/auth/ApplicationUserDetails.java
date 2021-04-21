package com.product.security.auth;

import com.product.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ApplicationUserDetails implements UserDetails {

  private String login;
  private String password;
  private List<? extends GrantedAuthority> grantedAuthorities;

  public static ApplicationUserDetails fromUserDtoToApplicationUserDetails(UserDTO dto) {
    ApplicationUserDetails userDetails = new ApplicationUserDetails();
    userDetails.login = dto.getLogin();
    userDetails.password = dto.getPassword();
    userDetails.grantedAuthorities =
        Collections.singletonList(new SimpleGrantedAuthority(dto.getRole()));
    return userDetails;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
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
    return false;
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
