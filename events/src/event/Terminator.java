package event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Terminator implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("se fudeu");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("dado");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("allan");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("dano");
    }
}
