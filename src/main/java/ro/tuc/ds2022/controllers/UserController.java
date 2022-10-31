package ro.tuc.ds2022.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.tuc.ds2022.dtos.UserDto;

import ro.tuc.ds2022.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto){
        Long idClient = userService.createUser(userDto);
        return new ResponseEntity<>("Client created with id " + idClient, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable(name = "id") Long userId) throws Exception {
        UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(name = "id") Long userId,
                                          @Valid @RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUser(userId, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") Long clientId){
        userService.deleteUser(clientId);
        return new ResponseEntity<>("Client deleted!", HttpStatus.OK);
    }





}
