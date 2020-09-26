package com.microservice.user.presentation.user;

import com.microservice.user.application.user.UserDTO;
import com.microservice.user.application.user.UserService;
import com.microservice.user.domain.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    public UserService userService;

    @CrossOrigin
    @RequestMapping(method=RequestMethod.GET, produces="application/json;charset=UTF-8")
    public List<UserDTO> getUser() {
        return userService.findAll();
    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.GET, value="{id}", produces="application/json;charset=UTF-8")
    public UserDTO getUser(@PathVariable String id) {
        return userService.findById(new UserId(id));
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO postUser(@RequestBody UserDTO user) {
        User addUser = new User(
                new UserId(user.getId()),
                new Name(user.getName()),
                new Password(user.getPassword())
        );
        return userService.add(addUser);
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public UserDTO putUser(@PathVariable String id,
                           @RequestBody UserDTO user) {
        User updateUser = new User(
                new UserId(id),
                new Name(user.getName()),
                new Password(user.getPassword())
        );
        return userService.update(updateUser);
    }

    @CrossOrigin
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        userService.delete(new User(new UserId(id),null,null));
    }
}