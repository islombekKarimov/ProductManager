package com.product.repository;


import com.product.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Islombek Karimov on 22.04.2020.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
