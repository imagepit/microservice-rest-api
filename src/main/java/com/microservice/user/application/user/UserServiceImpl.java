package com.microservice.user.application.user;
import com.microservice.user.domain.model.user.User;
import com.microservice.user.domain.model.user.UserId;
import com.microservice.user.domain.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user: users){
            userDTOs.add(convertDTO(user));
        }
        return userDTOs;
    }

    public UserDTO findById(UserId id) {
        return convertDTO(userRepository.findById(id));
    }

    public UserDTO add(User user) {
        userRepository.add(user);
        return this.findById(user.id());
    }

    public UserDTO update(User user) {
        userRepository.update(user);
        return this.findById(user.id());
    }

    public void delete(User user) {
        userRepository.delete(user.id());
    }

    private UserDTO convertDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.id().value());
        dto.setName(user.name().value());
        dto.setPassword(user.password().value());
        return dto;
    }
}
