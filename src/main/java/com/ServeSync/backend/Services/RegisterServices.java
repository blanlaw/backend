package com.ServeSync.backend.Services;

import com.ServeSync.backend.Entity.RegistersEntity;
import com.ServeSync.backend.Repository.RegisterRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class RegisterServices {


    @Autowired
    RegisterRepository registerRepository;

    public List<RegistersEntity> listregister() {
        return registerRepository.findAll();
    }

    public Optional<RegistersEntity> listregisterbyid(int id) {
        return registerRepository.findById(id);
    }

    public RegistersEntity saveregister(RegistersEntity registers) {
        return registerRepository.save(registers);
    }

    public void deleteregister(int id) {
        registerRepository.deleteById(id);
    }
}

