import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SwingHelloWorld {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame("Swing Hello World");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 250);

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName()
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

        // label
        JLabel label1;

        label1 = new JLabel("testing", JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        f.add(label1);

        //text field - entrada pequena
        f.setLayout(new FlowLayout());

        JTextField tField1, tField2, tField3;
        tField1 = new JTextField(10);
        tField2 = new JTextField("enter text");
        tField3 = new JTextField("uneditable text", 14);
        tField3.setEditable(false);

        f.add(tField1);
        f.add(tField2);
        f.add(tField3);

        // password field
        JPasswordField passField = new JPasswordField("hidden text");
        f.add(passField);

        // lendo campos
        String name = tField1.getText();

        char[] pass = passField.getPassword();

        System.out.println(name + " " + pass);

        // botões
        JButton b1, b2, b3;
        b1 = new JButton("disable m b");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);

        b2 = new JButton("m b");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);

        b3 = new JButton("enable m b");
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setEnabled(false);

        f.add(b1);
        f.add(b2);
        f.add(b3);

        // opções
        JRadioButton birdButton = new JRadioButton("bird");
        birdButton.setMnemonic(KeyEvent.VK_B);

        JRadioButton pigButton = new JRadioButton("pig");
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setSelected(true);

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(birdButton);
        radioGroup.add(pigButton);

        f.add(birdButton);
        f.add(pigButton);


        // check box
        JCheckBox chinButton = new JCheckBox("chin");
        JCheckBox hairButton = new JCheckBox("hair");

        chinButton.setMnemonic(KeyEvent.VK_C);
        hairButton.setMnemonic(KeyEvent.VK_H);

        f.add(chinButton);
        f.add(hairButton);

        // combo box
        String[] petStrings = {"Bird", "Cat", "Dog"};
        JComboBox petCombo = new JComboBox(petStrings);

        f.add(petCombo);

        // panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        panel1.setPreferredSize(new Dimension(12, 11));

        f.add(panel1);

        // option pane
        JOptionPane.showMessageDialog(f, "i love boobies <3");
        String[] options = {"poggers", "C#", "greve kkkkkk"};
        int opt = JOptionPane.showOptionDialog(f,
                "concordas?",
                "vasco!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        System.out.println(opt);

        GridLayout gridLayout = new GridLayout(3,2);
        f.setLayout(gridLayout);

        String[] names = {"Breno", "Bernal"};
        JButton[] buttons = new JButton[names.length];

        for (int i = 0; i<names.length; i++) {
            buttons[i] = new JButton(names[i]);
            f.add(buttons[i]);
        }

        // my panel
        JFrame frame = new JFrame("Color changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        frame.add(panel);

        frame.setSize(250, 150);
        //frame.setVisible(true);

        JTextArea textArea = new JTextArea("TESTING\nasdasdasd\nasdasd\nasdasds\nasdadn\nasdasdad\nasdadad\nasdasd\nasdadasd\nasdasdasd\nasdasd");
        textArea.setPreferredSize(new Dimension(200, 100));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(250,150));

        f.add(scrollPane);


        String[] colNames = {"Name", "Sport", "Years", "Vegetarian"};
        Object[][] data = {
                {"Kathy", "Snowboarding", 5, false},
                {"John", "Rowing", 3, true},
                {"Sue", "Knitting", 2, false},
                {"Jane", "Speed reading", 20, true},
                {"Joe", "Pool", 10, false}};
        JTable table = new JTable(data, colNames);
        table.setPreferredScrollableViewportSize(new Dimension(500,80));
        table.setFillsViewportHeight(true);
//Create the scroll pane and add the table to it. JScrollPane scrollPane = new JScrollPane (table);
//Add the scroll pane to the JFrame. f.add(scrollPane);

        f.add(table);

        f.setVisible(true);
    }
}
