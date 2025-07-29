package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.AuthRequest;
import com.example.studentmanagement.dto.AuthResponse;
import com.example.studentmanagement.model.Users;
import com.example.studentmanagement.repository.UserRepository;
import com.example.studentmanagement.config.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.generateToken(authentication);
        return new AuthResponse(token);
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "User already exists!";
        }

        // Hash password before saving (assuming you're using BCryptPasswordEncoder)
        user.setPassword(jwtUtil.encodePassword(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }
}
