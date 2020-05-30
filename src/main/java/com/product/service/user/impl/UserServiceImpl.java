package com.product.service.user.impl;

import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.service.user.UserService;
import com.product.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
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

    @Override
    public User getUserByLogin(String login) {
        Session session = HibernateUtil.session();
        Query query = session.createQuery("FROM User u where u.login = :user_login", User.class);
        query.setParameter("user_login", login);
        List<User> userList = query.list();
        User user = userList.get(0);
        return user;
    }

}
