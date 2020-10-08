import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.VetoableChangeListener;
import java.util.Arrays;

public class DictionaryGUI extends JFrame {
    private JPanel ApplicationUI;
    private JTextField textField1;
    private JButton button1;
    private JTextPane textPane1;
    private String[] words;
    private JList<String> list1;
    private JTextArea textArea1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField2;
    DefaultListModel<String> lm = new DefaultListModel<>();
    // private JList list2 = new JList(words);;

    public DictionaryGUI() {
        words = Dictionary.outPutNew("");
        lm.addAll(Arrays.asList(words));
        list1.setModel(lm);
        list1.setSelectedIndex(2);
        list1.setVisibleRowCount(2);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                /*lm = new DefaultListModel<>();
                String sel = textField1.getText();
                words = Dictionary.outPutNew(sel);
                lm.addAll(Arrays.asList(words));
                list1.setModel(lm);*/
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list1.getSelectedValue() != null) {
                    textArea1.setText((String)Dictionary.outPut(list1.getSelectedValue()));
                }
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_BACK_SPACE:
                        String current1 = textField1.getText();
                        current1 =current1.substring(0, current1.length() - 1);
                        lm = new DefaultListModel<>();
                        words = Dictionary.outPutNew(current1);
                        lm.addAll(Arrays.asList(words));
                        list1.setModel(lm);
                        //e.consume();
                        break;
                    default:
                        String current = textField1.getText() + e.getKeyChar();
                        lm = new DefaultListModel<>();
                        words = Dictionary.outPutNew(current);
                        lm.addAll(Arrays.asList(words));
                        list1.setModel(lm);
                        break;
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
