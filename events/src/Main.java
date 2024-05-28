import gridlayout.MyPanel;
import event.Terminator;
import event.SimpleFrame;
import multicast.MulticastPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static <SimpleFrame> void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.motif.MotifLookAndFeel"
            );
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        JFrame f = new JFrame("é 22 ou não é");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1280, 768);
        f.setLayout(new FlowLayout());

        GridLayout gridLayout = new GridLayout(3, 2);
        f.setLayout(gridLayout);

        String[] names = {"one", "two", "three", "four", "five", "six"};
        JButton[] buttons = new JButton[names.length];

        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
            f.add(buttons[i]);
            // add listener
        }
        MulticastPanel multicastPanel = new MulticastPanel();
        MyPanel myPanel = new MyPanel();
        f.add(myPanel);
        f.add(multicastPanel);
        Terminator terminator = new Terminator();

        f.addWindowListener(terminator);

        f.setVisible(true);
    }
}