package com.example.javaee;

import com.example.javaee.service.DatabaseService;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.sql.*;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    public HelloApplication() {
        DatabaseService.getConnection();
    }
}