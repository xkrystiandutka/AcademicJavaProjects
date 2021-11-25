package edu.lab06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CCuboid extends CSolid{

    protected int a;
    protected int b;

    public CCuboid(int mass, int a, int b) {
        super(mass);
        this.a = a;
        this.b = b;
    }

    @Override
    protected Double momentOfInertia() {
        return 1. / 12. * Mass * (a * a + b * b);
    }

    @Override
    protected void getData(JTable JT) {
        Mass = Integer.parseInt(JT.getValueAt(0, 1).toString());
        a = Integer.parseInt(JT.getValueAt(1, 1).toString());
        b = Integer.parseInt(JT.getValueAt(2, 1).toString());
    }

    @Override
    protected void showData(JTable JT, DefaultTableModel mod) {
        mod.setRowCount(3);
        JT.setValueAt("Masa", 0, 0);
        JT.setValueAt(Mass, 0, 1);
        JT.setValueAt("a", 1, 0);
        JT.setValueAt(a, 1, 1);
        JT.setValueAt("b", 2, 0);
        JT.setValueAt(b, 2, 1);
    }
}
