package com.java.domainstore.ui.view.component;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;

public class MyCB extends JCheckBox{

    public MyCB() {
        super("MyCB");
        setOpaque(false);
        setFont(new Font("Tahoma", Font.PLAIN, 12));
        setForeground(Color.BLACK);
    }
    
}
