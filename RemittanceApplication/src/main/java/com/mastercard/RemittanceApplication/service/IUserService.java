package com.mastercard.RemittanceApplication.service;


import com.mastercard.RemittanceApplication.dto.UserDTO;
import com.mastercard.RemittanceApplication.model.User;

import java.util.Optional;
import java.util.List;

public interface IUserService {

    public List<User> getAllUsers();

    public User findByUsername(String username);

    public User findUserById(int id);

    public String deleteUserById(int id);

    public List<User> getUserByUserRole(String userRole);

    public void updateUserRole(String userEmail,String newRole);

    public User getUserByEmail(String email);

    void saveUser(UserDTO userDTO);
}
