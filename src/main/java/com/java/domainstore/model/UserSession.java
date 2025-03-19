package com.java.domainstore.model;

// dùng singleton tạo UserSession đảm bảo chỉ có duy nhất 1 session được tạo
public class UserSession {
    private static UserSession instance;
    private String userId;

    private UserSession() {}  // Private constructor để ngăn việc khởi tạo trực tiếp

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void clearSession() {
        instance = null;  // Đăng xuất
    }
}
