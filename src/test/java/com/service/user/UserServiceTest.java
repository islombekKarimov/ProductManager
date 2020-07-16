package com.service.user;

import com.product.entity.User;
import com.product.repository.ProductRepository;
import com.product.repository.UserRepository;
import com.product.service.user.UserService;
import com.product.service.user.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.Optional.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Islombek Karimov on 22.06.2020.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserServiceImpl();


    @Test
    public void test_findAll() throws EntityNotFoundException {
//        List<User> userList = Arrays.asList(
//                new User(),
//                new User()
//        );
//        when(userRepository.findAll()).thenReturn(userList);
//        assertEquals("find all", 2, userService.findAll().size());
        verify(userRepository).findAll();
    }

    @Test
    public void findByIdTest() throws EntityNotFoundException{
        User user = new User();
        when(userRepository.findById(1)).thenReturn(ofNullable(user));
        User userDTO = userService.findById(1);
        assertThat(user.getName()).isEqualTo(userDTO.getName());
    }

    @Test
    public void deleteTest() throws EntityNotFoundException{
        User user = new User();
        when(userRepository.findById(1)).thenReturn(ofNullable(user));
        userService.delete(1);
        verify(userRepository).deleteById(1);
//        assertThat(user.getId().)
    }





}
