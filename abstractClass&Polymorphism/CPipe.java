package edu.lab06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CPipe extends CCylinder {

    private int r;

    @Override
    protected Double momentOfInertia() {
        return 0.5 * Mass * (R * R + r * r);
    }

    @Override
    protected void getData(JTable JT) {
        super.getData(JT);
        r = Integer.parseInt(JT.getValueAt(2, 1).toString());
    }

    @Override
    protected void showData(JTable JT, DefaultTableModel mod) {
        super.showData(JT,mod);
        mod.setRowCount(3);
        JT.setValueAt("r", 2, 0);
        JT.setValueAt(Mass, 2, 1);
    }

    public CPipe(int mass, int r, int r1) {
        super(mass, r);
        this.r = r1;
    }

}
