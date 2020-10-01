import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DictionaryGUI {
    private JPanel ApplicationUI;
    private JTextField textField1;
    private JButton button1;
    private JTextPane textPane1;
    private JButton button2;

    public DictionaryGUI() {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String sel = textField1.getText();
                textPane1.setText(Dictionary.outPut(sel));
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DictionaryManagement.insertFromFile();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    public static void runApplication() {
        JFrame gui = new JFrame("Dictionary");
        gui.setContentPane(new DictionaryGUI().ApplicationUI);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }
}
