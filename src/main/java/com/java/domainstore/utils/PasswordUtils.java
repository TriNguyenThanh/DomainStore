package com.java.domainstore.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {

    // Tạo salt ngẫu nhiên
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes (128 bits) salt
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    // Băm mật khẩu với salt bằng SHA-256
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes()); // Kết hợp salt với mật khẩu
            byte[] hashedBytes = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Lỗi khi băm mật khẩu", e);
        }
    }

    // Kiểm tra mật khẩu nhập vào với hash đã lưu
    public static boolean verifyPassword(String inputPassword, String storedHash, String salt) {
        String newHash = hashPassword(inputPassword, salt);
        return newHash.equals(storedHash);
    }
}
