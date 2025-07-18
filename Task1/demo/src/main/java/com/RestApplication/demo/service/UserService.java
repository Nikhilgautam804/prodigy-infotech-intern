package com.RestApplication.demo.service;

import com.RestApplication.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService {
    private final Map<UUID, User> users = new HashMap<>();

    public User createUser(User user){
        user.setId(UUID.randomUUID());
        users.put(user.getId(),user);
        return user;
    }
    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }
    public User getUserById(UUID id){
        User user = users.get(id);
        if(user == null) throw new NoSuchElementException("User not found");
        return user;
    }
    public User updateUser(UUID id , User updatedUser){
        if (!users.containsKey(id)) throw new NoSuchElementException("User not found");
        updatedUser.setId(id);
        users.put(id, updatedUser);
        return updatedUser;
    }
    public void deleteUser(UUID id){
        if(!users.containsKey(id)) throw new NoSuchElementException("User not found");
        users.remove(id);
    }
}
