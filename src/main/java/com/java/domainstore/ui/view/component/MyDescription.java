package com.java.domainstore.ui.view.component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class MyDescription extends JLabel{

    public MyDescription() {
        super("MyDescription");
        setFont(new Font("Tahoma", Font.ITALIC, 12));
        setForeground(Color.GRAY);
    }
}
