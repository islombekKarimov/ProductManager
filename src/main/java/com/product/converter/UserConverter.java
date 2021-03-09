package com.product.converter;

import com.product.dto.UserDTO;
import com.product.entity.User;

/**
 * UserConvertor.
 *
 * @author Islombek Karimov
 * @since 16.07.2020
 */
public class UserConverter {

  public UserConverter() {}

  public static UserDTO toDTO(User entity) {
    if (entity == null) return null;
    UserDTO dto =
        UserDTO.of()
            .setName(entity.getName())
            .setLogin(entity.getLogin())
            .setPassword(entity.getPassword());
    dto.setId(entity.getId());
    return dto;
  }

  public static User toEntity(UserDTO dto) {
    if (dto == null) return null;
    User entity =
        User.of().setName(dto.getName()).setLogin(dto.getLogin()).setPassword(dto.getPassword());
    entity.setId(dto.getId());
    return entity;
  }
}
