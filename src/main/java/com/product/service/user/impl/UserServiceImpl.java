package com.product.service.user.impl;

import com.product.converter.UserConverter;
import com.product.dto.UserDTO;
import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.service.user.UserService;
import com.product.util.HibernateUtil;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/** Created by Islombek Karimov on 08.05.2020. */
@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDTO create(UserDTO userDTO)
      throws ConstraintViolationException, EntityNotFoundException {
    User entity = UserConverter.toEntity(userDTO);
    return UserConverter.toDTO(userRepository.save(entity));
  }

  @Override
  public UserDTO get(Long id) {
    Optional<User> optional = findById(id);
    if (optional.isPresent()) {
      return UserConverter.toDTO(optional.get());
    } else {
      throw new EntityNotFoundException();
    }
  }

  @Override
  public UserDTO update(UserDTO userDTO) throws EntityNotFoundException {
    Optional<User> optional = findById(userDTO.getId());
    if (optional.isPresent()) {
      User entity = UserConverter.toEntity(userDTO);
      return UserConverter.toDTO(userRepository.save(entity));
    }else {
      throw new EntityNotFoundException();
    }
  }

  @Override
  public void delete(Long id) throws EntityNotFoundException {
    userRepository.deleteById(id);
  }

  @Override
  public Page<UserDTO> findAll(Pageable pageable) {
    return  userRepository.findAll(pageable).map(UserConverter::toDTO);
  }

  private Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  //  @Override
  //  public List<User> getUserByLogin(String login) {
  //    Session session = HibernateUtil.session();
  //    Transaction transaction = session.beginTransaction();
  //    Query query = session.createQuery("FROM User u where u.login = :user_login", User.class);
  //    query.setParameter("user_login", login);
  //    List<User> userList = query.list();
  //    transaction.commit();
  //    session.close();
  //    return userList;
  //  }
}
