package com.java.domainstore.ui.view.component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class MyTitle extends JLabel {

    public MyTitle() {
        super("MyTitle");
        setFont(new Font("Tahoma", Font.BOLD, 32));
        setForeground(Color.BLACK);
    }

}
