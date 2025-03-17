package com.java.domainstore.ui.view.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {
    private int radius;
    private Color defaultColor;
    private Color selectedColor;
    
    public MyButton() {
        super("My button");
        setContentAreaFilled(false); // Tắt hiệu ứng nền mặc định
        setFocusPainted(false); // Tắt viền khi focus
        
        radius = 15;
        defaultColor = Color.WHITE;
        selectedColor = Color.RED;

        // bắt sự kiện chuột
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setBackground(Color.GREEN); // Đổi màu nền khi click
            }


            // hiệu ứng hover
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(selectedColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultColor);
            }
        });
        
        setFont(new Font("Tahoma", Font.BOLD, 24) );
    }

    public MyButton(Color defaultColor, Color selectedColor) {
        this();
        this.defaultColor = defaultColor;
        this.selectedColor = selectedColor;
    }
    
    // ghi đè paintComponent để vẽ với hiệu ứng bo góc
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền bo góc
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // Bo góc 20px

        super.paintComponent(g);
    }

    //
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getBackground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }    

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }
}