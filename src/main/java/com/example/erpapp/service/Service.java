package com.example.erpapp.service;
import com.example.erpapp.model.User;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private static final List<User> users = new ArrayList<>();
    private static int id = 0;

    static {
        User u1 = new User(++id, "Adi", "Male", "7569594090", "Vizag");
        User u2 = new User(++id, "Adi1", "Male", "1234567890", "Hyd");


        users.add(u1);
        users.add(u2);

    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user){

        users.add(user);

        return user;



    }

    public User updateUser(int id,User user){
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setGender(user.getGender());
                u.setAddress(user.getAddress());
                u.setPhoneNumber(user.getPhoneNumber());
                return user;
            }
        }
        return null;

    }
    public String deleteUser(int id){
        for (User u : users) {
            if (u.getId() == id) {
               users.remove(u);
                return "user sucessfully deleted";
            }
        }
        return "user not found with given id:"+id;

    }
}




