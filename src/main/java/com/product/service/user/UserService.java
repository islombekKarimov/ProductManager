package com.product.service.user;

import com.product.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/** Created by Islombek Karimov on 25.04.2020. */
@Service
public interface UserService {
  UserDTO create(UserDTO userDTO);

  UserDTO get(Long id);

  UserDTO update(UserDTO userDTO);

  void delete(Long id);

  Page<UserDTO> findAll(Pageable pageable);
}
