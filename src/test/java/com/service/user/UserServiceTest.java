package com.service.user;

import com.data.TestDataProvider;
import com.product.ProductManagerApplication;
import com.product.dto.UserDTO;
import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.service.user.UserService;
import com.product.service.user.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/** Created by Islombek Karimov on 22.06.2020. */
@SpringBootTest(
    classes = ProductManagerApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
  private static final long userId = 1;

  @Mock private UserRepository userRepository;

  @InjectMocks private UserService userService = new UserServiceImpl();

  @Test
  public void test_create() {
    UserDTO userDTO = TestDataProvider.createUserDTO();
    User user = TestDataProvider.createUser();
    when(userRepository.save(any())).thenReturn(user);
    UserDTO result = userService.create(userDTO);
    assertNotNull(result);
    assertEquals(user.getName(), result.getName());
    verify(userRepository, times(1)).save(any());
  }

  @Test
  public void test_update() {
    UserDTO userDTO = TestDataProvider.createUserDTO();
    userDTO.setId(userId);
    User user = TestDataProvider.createUser();
    user.setId(userId);
    Optional<User> userOptional = Optional.of(user);
    when(userRepository.findById(userDTO.getId())).thenReturn(userOptional);
    when(userRepository.save(any())).thenReturn(user);
    UserDTO result = userService.update(userDTO);
    assertNotNull(result);
    assertEquals(user.getId(), result.getId());
    assertEquals(user.getLogin(), result.getLogin());
    verify(userRepository, times(1)).save(any());
  }

  @Test
  public void test_delete() {
    userService.delete(anyLong());
    verify(userRepository, times(1)).deleteById(anyLong());
  }

  @Test
  public void test_getNotFound() {
    when(userRepository.findById(userId)).thenReturn(Optional.empty());
    Assertions.assertThrows(EntityNotFoundException.class, () -> userService.get(userId));
  }

  @Test
  public void test_get() {
    User user = TestDataProvider.createUser();
    Optional<User> userOptional = Optional.of(user);
    when(userRepository.findById(anyLong())).thenReturn(userOptional);
    UserDTO result = userService.get(userId);
    assertNotNull(result);
    verify(userRepository, times(1)).findById(anyLong());
  }

  // TODO find out
  @Test
  public void test_getFindAll() {}
}
