package multicast;

import event.SimpleFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MulticastPanel extends JPanel implements ActionListener {
    private int counter=0;
    private JButton closeAllButton = new JButton("Close all");
    private JButton newButton = new JButton("New");

    public MulticastPanel() {
        this.add(newButton);
        this.add(closeAllButton);
        newButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        SimpleFrame f = new SimpleFrame();
        counter++;
        f.setTitle("Window " + this.counter);
        f.setBounds(30*counter, 30*counter, 200, 150);
        f.setVisible(true);
        closeAllButton.addActionListener(f);
    }
}
