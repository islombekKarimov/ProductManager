package com.product.repository;


import com.product.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Islombek Karimov on 22.04.2020.
 */
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
}
