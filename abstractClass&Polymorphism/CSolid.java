package edu.lab06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class CSolid {

    protected Integer Mass;

    public CSolid(int mass) {
        Mass = mass;
    }

    protected abstract Double momentOfInertia();
    protected abstract void getData(JTable tab);
    protected abstract void showData(JTable tab, DefaultTableModel mod);


}
