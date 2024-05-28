package event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFrame extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
