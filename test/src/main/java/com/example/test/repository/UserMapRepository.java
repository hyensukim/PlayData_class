package com.example.test.repository;

import com.example.test.entitiy.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapRepository implements UserRepository{

    private Map<Integer,User> userMap;

    public UserMapRepository(){
        this.userMap = new HashMap<>();
        User user1 = new User(1,"태양인",20);
        User user2 = new User(2,"찌디",21);
        User user3 = new User(3,"자이언턱",23);
        userMap.put(1,user1);
        userMap.put(2,user2);
        userMap.put(3,user3);

    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        for(int i =1; i < 4; i++){
            userList.add(userMap.get(i));
        }
        return userList;
    }

    @Override
    public User getUserByUserId(int userId) {
        for(int i =1; i < 4; i++){
            if(userMap.get(i).getUserId() == userId){
                return userMap.get(i);
            }
        }
        return null;
    }
}
