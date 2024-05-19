package com.ServeSync.backend.User;

import com.ServeSync.backend.Auth.dto.UserResponse;
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

    public List<UserResponse> obtenerUsuarios() {
        return userRepository.findAll().stream().map(a -> {
            UserResponse userResponse = new UserResponse();                         /*le paso los datos por el dto */
            userResponse.setName(a.getName());
            userResponse.setLastname(a.getLastname());
            userResponse.setYears(a.getYears());
            userResponse.setEmail(a.getEmail());
            userResponse.setPassword(a.getPassword());
            userResponse.setCellphone(a.getCellphone());
            return userResponse;
        }).toList();
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
