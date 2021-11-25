package edu.lab11;

import observer.CConsoleObserver;
import observer.CFileObserver;
import observer.CJListObserver;
import solver.CSolver;
import solver.CSolverCreator;
import solver.CStepData;
import solver.ESolverType;

import javax.swing.*;
import java.awt.*;

public class CMainForm extends JFrame {

    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuOptions;
    private JMenuItem itemSolver;
    private JMenuItem itemExit;
    private JMenuItem itemAbout;
    private JRadioButton rbFirst;
    private JRadioButton rbSecond;
    private JRadioButton rbFourth;
    private JCheckBox cbPanel;
    private JCheckBox cbConsole;
    private JCheckBox cbFile;
    private JTextField tkTextField;
    private JTextField alphaTextField;
    private JTextField omegaTextField;
    private JList list1;

    private DefaultListModel<Object> model;

    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultListModel<>();
        list1.setModel(model);


        itemExit.addActionListener(e -> CMainForm.this.dispose());
        itemSolver.addActionListener(e -> solveActionPerformed());
        itemAbout.addActionListener(e -> JOptionPane.showMessageDialog(
                CMainForm.this, "Programowanie obiektowe\nlaboratorium 11",
                "O pogramie", JOptionPane.INFORMATION_MESSAGE));
    }

    private void solveActionPerformed() {

        CSolverCreator sc = new CSolverCreator();

        ESolverType st = ESolverType.FIRST_ORDER;
        if (rbSecond.isSelected()) st = ESolverType.SECOND_ORDER;
        else if (rbFourth.isSelected()) st = ESolverType.FOURTH_ORDER;

        try {
                CStepData init = new CStepData(
                        Double.parseDouble(tkTextField.getText().trim()),
                        Double.parseDouble(alphaTextField.getText().trim()),
                        Double.parseDouble(omegaTextField.getText().trim())
                );

                CSolver solverObj = sc.getSolver(st, init);

                if (cbPanel.isSelected())
                    solverObj.addObserver(new CJListObserver(model));
                if (cbConsole.isSelected())
                    solverObj.addObserver(new CConsoleObserver());
                if (cbFile.isSelected())
                    solverObj.addObserver(new CFileObserver());
                solverObj.solve();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Niepoprawna wartość. Komunikat: " + e.getMessage());
        }

    }

}
