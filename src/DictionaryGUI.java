import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.VetoableChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DictionaryGUI extends JFrame {
    private JPanel ApplicationUI;
    private JTextField textField1;
    private JButton button1;
    private JTextPane textPane1;
    private String[] words;
    private final String[] defaults = Dictionary.outPutNew("");;
    private JList<String> list1;
    private JTextArea textArea1;
    private JButton unloadButton;
    private JButton newButton;
    private JButton deleteButton;
    private JButton speakButton;
    private JButton translateButton;
    private JTextField textField2;
    DefaultListModel<String> lm = new DefaultListModel<>();
    // private JList list2 = new JList(words);;
    private static final JFrame gui = new JFrame("Dictionary");

    public DictionaryGUI() {

        //lm.addAll(Arrays.asList(defaults));
        for (String word: defaults) {
            lm.addElement(word);
        }
        list1.setModel(lm);
        list1.setSelectedIndex(1);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DictionaryManagement.insertFromFile();
                    //lm.addAll(Arrays.asList(defaults));
                    for (String word: defaults) {
                        lm.addElement(word);
                    }
                    list1.setModel(lm);
                    list1.setSelectedIndex(1);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
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
                        if (current1.isEmpty()) {
                            e.consume();
                            break;
                        }
                        current1 =current1.substring(0, current1.length() - 1);
                        lm = new DefaultListModel<>();
                        words = Dictionary.outPutNew(current1);
                        for (String word : words) {
                            lm.addElement(word);
                        }

                        //lm.addAll(Arrays.asList(words));

                        list1.setModel(lm);
                        //e.consume();
                        break;
                    case KeyEvent.VK_CONTROL:
                        e.consume();
                        break;
                    default:
                        String current = textField1.getText() + e.getKeyChar();
                        lm = new DefaultListModel<>();
                        words = Dictionary.outPutNew(current);
//                        for (String word : words) {
//                            lm.addElement(word);
//                        }
                        //lm.addAll(Arrays.asList(words));
                        for (String word: words) {
                            lm.addElement(word);
                        }
                        list1.setModel(lm);
                        break;
                }

            }
        });

        speakButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String word = list1.getSelectedValue();
                String[] parts = word.split("[/]" , 2);
                Voice voice = new Voice();
                voice.Speak(parts[0]);

            }
        });

        unloadButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    DictionaryManagement.dictionaryExportToFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        newButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                gui.pack();
                gui.setVisible(true);
                String name = JOptionPane.showInputDialog(gui,"Word", null);
                String word = JOptionPane.showInputDialog(gui,"Definition", null);
                if (name != null && word != null) {
                    Dictionary.addNewWord(name, word);
                }
                }
        });
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String wordToDelete = JOptionPane.showInputDialog(gui,"Word", null);
                if (wordToDelete != null) {
                    Dictionary.removeWord(wordToDelete);
                    lm = new DefaultListModel<>();
                    //lm.addAll(Arrays.asList(defaults));
                    for (String word: defaults) {
                        lm.addElement(word);
                    }
                    list1.setModel(lm);
                    list1.setSelectedIndex(1);
                }
            }
        });
        translateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String wordToTranslate = JOptionPane.showInputDialog(gui,"Word", null);
                if (wordToTranslate != null) {
                    try {
                        JOptionPane.showMessageDialog(gui, Translator.Post(wordToTranslate));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }
    public static void runApplication() {

        gui.setContentPane(new DictionaryGUI().ApplicationUI);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);

    }
}
