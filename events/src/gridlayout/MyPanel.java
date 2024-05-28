package gridlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MyPanel extends JPanel implements ActionListener {
    private JButton yellowButton = new JButton("Yellow");
    private JButton blueButton = new JButton("Blue");
    private JButton redButton = new JButton("Red");

    public MyPanel() {
        this.add(yellowButton);
        this.add(blueButton);
        this.add(redButton);

        FocusListener focusListener = new FocusListener();

        yellowButton.addFocusListener(focusListener);
        blueButton.addFocusListener(focusListener);
        redButton.addFocusListener(focusListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        backgroundSetter(source);
    }

    class FocusListener extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            Object source = e.getComponent();
            backgroundSetter(source);
        }
    }

    void backgroundSetter (Object source) {
        if (source == yellowButton) {
            setBackground(Color.yellow);
        } else if (source == blueButton) {
            setBackground(Color.blue);
        } else if (source == redButton) {
            setBackground(Color.red);
        }
    }
}
