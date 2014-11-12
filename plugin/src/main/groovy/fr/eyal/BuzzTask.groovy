package main.groovy.fr.eyal

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager

import static javax.swing.SwingUtilities.invokeLater;


class BuzzTask extends DefaultTask {

    @TaskAction
    def exec() {
        //we configure the environment
        project.buzz.processConfiguration()

        invokeLater(new Runnable() {
            @Override
            public void run() {

                println "START PLAYING"
                SoundJLayer soundToPlay = new SoundJLayer("arrow.mp3");
                soundToPlay.play();
                println "DONE PLAYING"

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (final Exception e1) {
                    e1.printStackTrace();
                }

                final NotificationPopup f = new NotificationPopup();

                final Container c = f.getContentPane();
                c.setLayout(new GridBagLayout());

                final GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.weightx = 1.0f;
                constraints.weighty = 1.0f;
                constraints.insets = new Insets(5, 5, 5, 5);
                constraints.fill = GridBagConstraints.BOTH;

                final JLabel l = new JLabel("Hey! Your task is finished :-)");
                l.setOpaque(false);

                c.add(l, constraints);

                constraints.gridx++;
                constraints.weightx = 0f;
                constraints.weighty = 0f;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.NORTH;

                final JButton b = new JButton(new AbstractAction("x") {

                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        f.dispose();
                    }
                });

                b.setOpaque(false);
                b.setMargin(new Insets(1, 4, 1, 4));
                b.setFocusable(false);

                c.add(b, constraints);

                f.setVisible(true);

                Thread.start {
                    Thread.sleep(10000);
                    f.dispose();
                }
            }
        });
     }
}
