package com.talentmatch.user_service.service;

import com.talentmatch.user_service.entity.User;
import com.talentmatch.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setDasId(user.getDasId());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
