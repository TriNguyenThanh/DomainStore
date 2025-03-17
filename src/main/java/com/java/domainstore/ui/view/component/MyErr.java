package com.java.domainstore.ui.view.component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class MyErr extends JLabel{
    public MyErr() {
        super("* error");
        setForeground(Color.red);
        setFont(new Font("tahoma", Font.ITALIC, 12));
    }
}
