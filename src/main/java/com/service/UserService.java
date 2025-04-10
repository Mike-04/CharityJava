package com.service;

import com.domain.User;
import com.repository.UserIRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserService {
    private final UserIRepository userRepository;
    private static final Logger logger = LogManager.getLogger(UserService.class);

    public UserService(UserIRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static String hashPassword(String username, String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String saltedPassword = username + password; // Use username as salt
            byte[] hash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static boolean checkPassword(String username, String password, String hash) {
        String newHash = hashPassword(username, password);
        return newHash.equals(hash);
    }

    public void addUser(String username, String password) {
        password = hashPassword(username, password);
        userRepository.add(new User(username, password));
    }

    public boolean checkUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        return checkPassword(username, password, user.getPasswordHash());
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.remove(user.getId());
        }
    }

    public void updateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            password = hashPassword(username, password);
            userRepository.update(new User(user.getId(), username, password));
        }
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return StreamSupport.stream(userRepository.getAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}