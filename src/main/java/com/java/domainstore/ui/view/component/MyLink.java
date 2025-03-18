package com.java.domainstore.ui.view.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class MyLink extends JLabel{
    private Color defaultForeground;
    
    public MyLink() {
        super("MyLink");
        defaultForeground = Color.BLACK;
        setFont(new Font("tahoma", Font.ITALIC, 12));
        setForeground(Color.BLACK);
        
        // hiệu ứng hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(defaultForeground);
            }
        });
    }

    public Color getDefaultForeground() {
        return defaultForeground;
    }

    public void setDefaultForeground(Color defaultForeground) {
        this.defaultForeground = defaultForeground;
    }
    
}
