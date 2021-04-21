package com.product.security.auth;

import com.product.converter.UserConverter;
import com.product.dto.UserDTO;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public ApplicationUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    UserDTO userDTO = UserConverter.toDTO(userService.findUserByLogin(login).get());
    return ApplicationUserDetails.fromUserDtoToApplicationUserDetails(userDTO);
  }
}
