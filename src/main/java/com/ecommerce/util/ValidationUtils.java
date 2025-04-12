package com.ecommerce.util;

import com.ecommerce.config.ApplicationConfig;

public class ValidationUtils {
    public static boolean isValidName(String name) {
        return name != null && 
               !name.trim().isEmpty() && 
               name.length() <= ApplicationConfig.MAX_CLIENT_NAME_LENGTH;
    }

    public static boolean isValidEmail(String email) {
        return email != null && 
               email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && 
               password.length() >= ApplicationConfig.MIN_PASSWORD_LENGTH;
    }

    public static boolean isValidProductName(String name) {
        return name != null && 
               !name.trim().isEmpty() && 
               name.length() <= ApplicationConfig.MAX_PRODUCT_NAME_LENGTH;
    }

    public static boolean isValidPrice(float price) {
        return price > 0;
    }
} 