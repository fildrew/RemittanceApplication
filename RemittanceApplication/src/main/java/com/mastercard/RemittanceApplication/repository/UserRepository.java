package com.mastercard.RemittanceApplication.repository;

import com.mastercard.RemittanceApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);

    public List<User> findUserByUserRole(String userRole);
}
