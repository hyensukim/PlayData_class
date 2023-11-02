package com.example.test.repository;

import com.example.test.entitiy.User;

import java.util.List;

public interface UserRepository {

    public List<User> getAllUser();

    public User getUserByUserId(int userId);

}
