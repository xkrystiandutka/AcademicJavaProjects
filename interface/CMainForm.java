package edu.lab7;

import edu.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CMainForm extends JFrame {
    protected CDocument document;
    private JPanel mainPanel;
    private JPanel graphicArea;

    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //document.addShape(new CShapeCircle(300, 500, Color.lightGray, Color.BLACK, 70));
        document = new CDocument((CGraphicArea) graphicArea);
        document.addShape(new CShapeCircle(200, 400, Color.YELLOW, Color.BLACK, 80));
        document.addShape(new CPolyRTriangle(350, 450, Color.BLUE, Color.BLACK, 150, 100));
        document.addShape(new CPolySquare(50, 50, Color.GREEN, Color.BLACK, 100, 150));
        document.addShape(new CPolyZBar(200, 50, Color.RED, Color.BLACK, 100, 150));
        document.addShape(new CPolyChannel(400, 50, Color.DARK_GRAY, Color.BLACK, 100, 150));
        document.addShape(new CPolyTBar(550, 50, Color.magenta, Color.BLACK, 100, 150));
        document.addShape(new CPolyIBeam(700, 50, Color.CYAN, Color.BLACK, 100, 150));
        document.addShape(new CPolyTube(850, 50, Color.ORANGE, Color.BLACK, 150, 150));
        document.redraw();

        graphicArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                graphicAreaMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                graphicAreaMouseReleased();
            }
        });

        graphicArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                graphicAreaMouseDragged(e);
            }
        });
    }

    private void createUIComponents() {
        graphicArea = new CGraphicArea();
    }

    private void graphicAreaMousePressed(MouseEvent evt) {
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (document.selectShape(evt.getX(), evt.getY()))
                document.redraw();
        }
    }

    private void graphicAreaMouseReleased() {
        document.deselectShape();
        document.redraw();
    }

    private void graphicAreaMouseDragged(MouseEvent evt) {
        document.moveSelected(evt.getX(), evt.getY());
        long time = document.redraw();
        if (time > 0)
            setTitle(String.format("Kształtowniki, czas rysowania %d ms", time));
    }
}
