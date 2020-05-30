package com.product.service.user;

import com.product.entity.User;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import sun.corba.EncapsInputStreamFactory;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Islombek Karimov on 25.04.2020.
 */
@Service
public interface UserService {
    User create(User user) throws ConstraintViolationException, EntityNotFoundException;
    User findById(int id) throws EntityNotFoundException;
    User update(User user, int id) throws EntityNotFoundException;
    void delete(int id) throws EntityNotFoundException;
    List<User> findAll();
    User getUserByLogin(String login);

}
