package edu.lab10;
import generic.CMyLinkedList;

import javax.swing.*;
import java.awt.*;

public class CImgListRenderer extends DefaultListCellRenderer {
    private final CMyLinkedList<Integer, ImageIcon> list;

    public CImgListRenderer(CMyLinkedList<Integer, ImageIcon> list) {
        this.list = list;
    }

    private Icon getIcon(CMyLinkedList<Integer, ImageIcon> l, int i) {
        return l.getByIndex(i);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Icon icon = getIcon(this.list, index);
        label.setText("");
        label.setIcon(icon);

        return label;
    }
}
