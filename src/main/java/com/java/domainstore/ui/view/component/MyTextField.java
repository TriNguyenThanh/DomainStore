package com.java.domainstore.ui.view.component;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    private int radius = 15; // Độ cong của góc

    public MyTextField() {
        super();
        setOpaque(false); // Loại bỏ nền mặc định
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Tạo padding bên trong
        setFont(new Font("Tahoma", Font.PLAIN, 18));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Không vẽ viền mặc định
    }
}
