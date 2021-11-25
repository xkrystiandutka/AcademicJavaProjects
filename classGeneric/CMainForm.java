package edu.lab10;

import generic.CMyLinkedList;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CMainForm extends JFrame {
    private final DefaultListModel<Object> modelStr;
    private final DefaultListModel<Object> modelInt;
    private final DefaultListModel<Object> modelPerson;
    private final DefaultListModel<Object> modelImg;
    private final CMyLinkedList<Integer, String> myListStr;
    private final CMyLinkedList<Byte, Integer> myListInt;
    private final CMyLinkedList<Long, CPerson> myListPerson;
    private final CMyLinkedList<Integer, ImageIcon> myListImg;
    private JPanel mainPanel;
    private JButton strButton;
    private JTextField strTextField;
    private JList<Object> strList;
    private JTextField strIdField;
    private JButton strClear;
    private JTextField strFind;
    private JButton strFindId;
    private JButton strFindIndex;
    private JTextField intTextField;
    private JButton intButton;
    private JList<Object> intList;
    private JTextField intIdField;
    private JTextField personTextFname;
    private JTextField personTextName;
    private JComboBox personYear;
    private JButton personButton;
    private JTextField personIdField;
    private JList<Object> personList;
    private JButton imgButton;
    private JTextField imgIdField;
    private JList<Object> imgList;

    public CMainForm(String title) throws HeadlessException {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        myListStr = new CMyLinkedList<>();
        myListInt = new CMyLinkedList<>();
        myListPerson = new CMyLinkedList<>();
        myListImg = new CMyLinkedList<>();

        modelStr = new DefaultListModel<>();
        modelInt = new DefaultListModel<>();
        modelPerson = new DefaultListModel<>();
        modelImg = new DefaultListModel<>();

        strList.setModel(modelStr);
        intList.setModel(modelInt);
        personList.setModel(modelPerson);
        imgList.setModel(modelImg);
        imgList.setCellRenderer(new CImgListRenderer(this.myListImg));

        strButton.addActionListener(e -> strButtonClick());

        strClear.addActionListener(e -> strButtonClearClick());

        strFindId.addActionListener(e -> strGetByIdClick());

        strFindIndex.addActionListener(e -> strGetByIndexClick());

        intButton.addActionListener(e -> intButtonClick());

        personButton.addActionListener(e -> personButtonClick());

        imgButton.addActionListener(e -> imageButtonClick());
    }

    private void strButtonClick() {
        try {
            Integer n = Integer.parseInt(strIdField.getText());
            String text = strTextField.getText().trim();
            if (text.compareTo("") != 0) {
                myListStr.add(n, text);
            }
            myListStr.printToList(modelStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość. Komunikat: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void strButtonClearClick() {
        myListStr.clear();
        myListStr.printToList(modelStr);
    }

    private void strGetByIndexClick() {
        try {
            int idx = Integer.parseInt(strFind.getText());
            String s = myListStr.getByIndex(idx);
            JOptionPane.showMessageDialog(this, "Zwrócona wartość: " + s);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość indeksu. Komunikat: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void strGetByIdClick() {
        try {
            int id = Integer.parseInt(strFind.getText());
            String s = myListStr.getById(id);
            if (s != null) {
                JOptionPane.showMessageDialog(this, "Zwrócona wartość: " + s);
            } else {
                JOptionPane.showMessageDialog(this, "Brak elementu o id = " + id);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość. Komunikat: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void intButtonClick() {
        try {
            Byte d = Byte.parseByte(intIdField.getText());
            Integer v = Integer.parseInt(intTextField.getText());
            myListInt.add(d, v);
            myListInt.printToList(modelInt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość. Komunikat: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void personButtonClick() {
        try {
            Long n = Long.parseLong(personIdField.getText());
            CPerson person = new CPerson(
                    personTextFname.getText(),
                    personTextName.getText(),
                    Integer.parseInt(personYear.getItemAt(personYear.getSelectedIndex()).toString())
            );
            myListPerson.add(n, person);
            myListPerson.printToList(modelPerson);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość. Komunikat: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void imageButtonClick() {
        try {
            Integer n = Integer.parseInt(imgIdField.getText());
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                myListImg.add(n, new ImageIcon(fc.getSelectedFile().getAbsolutePath()));
                myListImg.printToList(modelImg);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Niepoprawna wartość. Komunikat: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
