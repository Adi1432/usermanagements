package com.example.erpapp.controller;
import com.example.erpapp.model.User;
import com.example.erpapp.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class Controller {

    @Autowired
    private Service erpService;
    @GetMapping("find-all-users")
    public List<User> getAllUsers(){
        return erpService.findAll();
    }

    @GetMapping("find-user/id/{id}")
    public User getuser(@PathVariable int id){
        return erpService.findUser(id);
    }

    @PostMapping("adduser")
    public User createUser(@RequestBody User user){

        return erpService.addUser(user);

    }

    @PutMapping("updateuser/id/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id){
        return erpService.updateUser(id,user);
    }

    @DeleteMapping("delete/id/{id}")
    public String deleteUser(@PathVariable int id){
        return erpService.deleteUser(id);
    }
}
