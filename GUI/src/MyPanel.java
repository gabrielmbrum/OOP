import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    private JButton yellowButton = new JButton("yellow");
    private JButton redButton = new JButton("red");
    private JButton blueButton = new JButton("blue");

    public MyPanel() {
        this.add(yellowButton);
        this.add(redButton);
        this.add(blueButton);

        yellowButton.addActionListener(this);
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

        if (source == yellowButton) {
            setBackground(Color.YELLOW);
        } else if (source == redButton) {
            setBackground(Color.RED);
        } else if (source == blueButton) {
            setBackground(Color.BLUE);
        }
    }
}
