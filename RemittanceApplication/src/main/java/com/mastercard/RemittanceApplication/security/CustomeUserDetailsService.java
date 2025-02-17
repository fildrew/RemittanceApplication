package com.mastercard.RemittanceApplication.security;

import com.mastercard.RemittanceApplication.model.User;
import com.mastercard.RemittanceApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);

        if(user == null)
        {
            throw new UsernameNotFoundException("Username with :"+email+" is not found in the Database");
        }

        return new CustomeUserDetails(user);
    }
}
