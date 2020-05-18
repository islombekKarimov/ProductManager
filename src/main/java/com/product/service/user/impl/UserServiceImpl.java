package com.product.service.user.impl;

import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.service.user.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;


    @Override
    public User create(User user) throws ConstraintViolationException, EntityNotFoundException {
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) throws EntityNotFoundException {
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user, int id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
