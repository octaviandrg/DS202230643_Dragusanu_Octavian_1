package ro.tuc.ds2022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tuc.ds2022.config.JwtTokenProvider;
import ro.tuc.ds2022.dtos.UserDto;
import ro.tuc.ds2022.entities.User;
import ro.tuc.ds2022.repositories.RoleRepository;
import ro.tuc.ds2022.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registration")
    public ResponseEntity<?> registerUserAccount() throws Exception {
        UserDto userDto = new UserDto("Ion", "555");

        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new Exception("There is an account with that username: " + userDto.getUsername());
        }

        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), List.of(roleRepository.findByName("ROLE_ADMIN")));
        userRepository.save(user);

        return new ResponseEntity<>("User register successfully!", HttpStatus.ACCEPTED);
    }

//    @GetMapping("/login")
//    public ResponseEntity<?> loginUserAccount(@RequestBody UserDto userDto) throws Exception {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String token = tokenProvider.generateToken(authentication);
//        return new ResponseEntity<>("User singed-up successfully. Token: " + token, HttpStatus.OK);
//    }

}
