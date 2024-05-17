package com.ServeSync.backend.Controller;

import com.ServeSync.backend.Entity.RegistersEntity;
import com.ServeSync.backend.Entity.UserEntity;
import com.ServeSync.backend.Services.RegisterServices;
import com.ServeSync.backend.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path ="/register")
public class RegisterController {
    @Autowired
    private RegisterServices registerServices;
    @GetMapping("/list")
    public List<RegistersEntity> list(){

        return registerServices.listregister();
    }

    @PostMapping("/save")
    public void save (@RequestBody RegistersEntity registers){


        registerServices.saveregister(registers);
    }


}
