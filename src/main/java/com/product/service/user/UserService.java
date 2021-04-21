package com.product.service.user;

import com.product.dto.UserDTO;
import com.product.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/** Created by Islombek Karimov on 25.04.2020. */
public interface UserService {
  UserDTO create(UserDTO userDTO);

  UserDTO get(Long id);

  UserDTO update(UserDTO userDTO);

  void delete(Long id);

  Page<UserDTO> findAll(Pageable pageable) throws Exception;

  Optional<User> findUserByLogin(String login);
}
