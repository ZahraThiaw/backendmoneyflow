package com.backendmycash.services.impl;

import com.backendmycash.data.entities.User;
import com.backendmycash.data.repositories.UserRepository;
import com.backendmycash.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractBaseService<User, Integer> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);  // Fournir le UserRepository ici
    }
}
