package com.java.domainstore.ui.view.component;

import java.awt.*;
import javax.swing.*;

public class MyCB extends JCheckBox {

    public MyCB() {
        super("MyCB");
        setOpaque(false);
        setFont(new Font("Tahoma", Font.PLAIN, 12));
        setForeground(Color.BLACK);

        // Make it not look like a standard checkbox
        this.setFocusPainted(false);
        this.setBorderPainted(false);

        // Use custom icons
        this.setIcon(createCustomIcon(false));
        this.setSelectedIcon(createCustomIcon(true));
    }

    private static Icon createCustomIcon(boolean selected) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int size = getIconWidth();

                if (selected) {
                    // Fill background with blue when selected
                    g2d.setColor(new Color(66, 133, 244));
                    g2d.fillRoundRect(x, y, size, size, 5, 5);

                    // Draw checkmark
                    g2d.setColor(Color.WHITE);
                    g2d.setStroke(new BasicStroke(2));
                    g2d.drawLine(x + 4, y + 9, x + 7, y + 12);
                    g2d.drawLine(x + 7, y + 12, x + 14, y + 5);
                } else {
                    // Draw empty box when not selected
                    g2d.setColor(Color.LIGHT_GRAY);
                    g2d.drawRoundRect(x, y, size - 1, size - 1, 4, 4);
                }
            }

            @Override
            public int getIconWidth() {
                return 18;
            }

            @Override
            public int getIconHeight() {
                return 18;
            }
        };
    }
}
