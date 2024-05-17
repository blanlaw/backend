package com.ServeSync.backend.Controller;

import com.ServeSync.backend.Entity.UserEntity;
import com.ServeSync.backend.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServices  userServices;
    @GetMapping("/list")
    public List<UserEntity> list(){

        return userServices.obtenerUsuarios();
    }

    @PostMapping("/save")
    public void save (@RequestBody UserEntity user){


        userServices.saveuser(user);
    }
    @GetMapping("{id}")
    public Optional<UserEntity> userbyid (@PathVariable int id){
        return userServices.listbyid(id);
    }


}
