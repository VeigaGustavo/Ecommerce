package com.ecommerce.config;

public class ApplicationConfig {
    public static final String APP_NAME = "Sistema de E-commerce";
    public static final String APP_VERSION = "1.0.0";
    
    // Configurações de banco de dados (quando implementado)
    public static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "password";
    
    // Configurações de arquivos
    public static final String DATA_DIR = "data";
    public static final String LOG_DIR = "logs";
    
    // Configurações de validação
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PRODUCT_NAME_LENGTH = 100;
    public static final int MAX_CLIENT_NAME_LENGTH = 100;
} 