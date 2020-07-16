package com.product.converter;

import com.product.dto.UserDTO;
import com.product.entity.User;
import java.util.function.Function;
import org.springframework.stereotype.Service;

/**
 * UserConvertor.
 *
 * @author Islombek Karimov
 * @since 16.07.2020
 */
@Service
public class UserConverter extends Converter<UserDTO, User> {

  public UserConverter() {
    super(UserConverter::toEntity, UserConverter::toDTO);
  }

  private static UserDTO toDTO(User entity) {
    UserDTO dto =
        UserDTO.of()
            .setName(entity.getName())
            .setLogin(entity.getLogin())
            .setPassword(entity.getPassword());
    dto.setId(entity.getId());
    return dto;
  }

  private static User toEntity(UserDTO dto) {
    User entity =
        User.of().setName(dto.getName()).setLogin(dto.getLogin()).setPassword(dto.getPassword());
    entity.setId(dto.getId());
    return entity;
  }
}
