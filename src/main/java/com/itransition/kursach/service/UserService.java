package com.itransition.kursach.service;

import com.itransition.kursach.entity.Role;
import com.itransition.kursach.entity.User;
import com.itransition.kursach.repository.CompositionRepository;
import com.itransition.kursach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final CompositionRepository compositionRepository;

    @Autowired
    public UserService(UserRepository userRepository, CompositionRepository compositionRepository) {
        this.userRepository = userRepository;
        this.compositionRepository = compositionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean createUser(User user){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null){
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return true;
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    public void updateProfile(User user, String password, String email) {
    String userEmail = user.getEmail();
    if ((email != null && !email.equals(userEmail))){
        user.setEmail(email);
    }
    if (!StringUtils.isEmpty(password)) {
        user.setPassword(password);
    }
    userRepository.save(user);
    }

    public void banedUser(User user){
        if(user.isActive()){
            user.setActive(false);
        } else{
            user.setActive(true);
        }
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        compositionRepository.deleteAll(compositionRepository.findCompositionByUserId(user.getId()));
        userRepository.deleteById(user.getId());
    }
}