package main.groovy.fr.eyal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eyal on 10/11/14.
 */
public class NotificationPopup extends JDialog {
    private final LinearGradientPaint lpg;

    public NotificationPopup() {
        setUndecorated(true);
        setSize(300, 100);

        // size of the screen
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // height of the task bar
        final Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(
                getGraphicsConfiguration());
        final int taskBarSize = scnMax.bottom;

        setLocation(screenSize.width - getWidth(), 0); //screenSize.height - taskBarSize - getHeight());

        // background paint
        lpg = new LinearGradientPaint(0, 0, 0, getHeight() / 2,
                new float[] { 0f, 0.3f, 1f },
                new Color[] { new Color(0.8f, 0.8f, 1f),
                              new Color(0.7f, 0.7f, 1f),
                              new Color(0.6f, 0.6f, 1f)
                }
        );

        // blue background panel
        setContentPane(new BackgroundPanel());
    }

    private class BackgroundPanel extends JPanel {
        public BackgroundPanel() {
            setOpaque(true);
        }

        @Override
        protected void paintComponent(final Graphics g) {
            final Graphics2D g2d = (Graphics2D) g;
            // background
            g2d.setColor(Color.WHITE);
            //g2d.setPaint(lpg);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setColor(Color.BLACK);

            // border
            //g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
}