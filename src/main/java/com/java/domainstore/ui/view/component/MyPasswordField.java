package com.java.domainstore.ui.view.component;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField {

    private int radius;
    private final char defaultChar;

    public MyPasswordField() {
        super("pass");
        radius = 15;
        defaultChar = '•';
        setOpaque(false); // Loại bỏ nền mặc định
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Tạo padding bên trong
        setFont(new Font("Tahoma", Font.PLAIN, 18));
        setEchoChar(defaultChar);
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
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void show() {
        setEchoChar((char) 0);
    }

    public void hide() {
        setEchoChar(defaultChar);
    }
}
