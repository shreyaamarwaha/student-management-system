package com.example.studentmanagement.service;
public interface AuthService {
    void register(AuthRequest request);
    boolean login(AuthRequest request);
}
