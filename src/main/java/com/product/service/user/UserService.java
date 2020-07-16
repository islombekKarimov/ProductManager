package com.product.service.user;

import com.product.dto.UserDTO;
import com.product.entity.User;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Islombek Karimov on 25.04.2020.
 */
@Service
public interface UserService {
    User create(User userDTO) throws ConstraintViolationException, EntityNotFoundException;
    User findById(int id) throws EntityNotFoundException;
    User update(User userDTO, int id) throws EntityNotFoundException;
    void delete(int id) throws EntityNotFoundException;
    List<User> findAll();
    List<User> getUserByLogin(String login);


}
