package com.ServeSync.backend.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class UserServices  {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> obtenerUsuarios() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> listbyid(int id) {
        return userRepository.findById(id);
    }

    public UserEntity saveuser(UserEntity usuario) {
        return userRepository.save(usuario);
    }

    public void deleteuser(int id) {
        userRepository.deleteById(id);
    }
}
