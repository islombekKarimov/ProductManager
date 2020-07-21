package com.product.repository;


import com.product.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Islombek Karimov on 22.04.2020.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
