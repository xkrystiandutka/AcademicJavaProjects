package edu.lab06;

import javax.swing.*;
import java.awt.*;
//import java.awt.geom.*;


/**
 *
 * @author Grzegorz
 */
public class CPaintPanel extends JPanel {
    private int Width;
    private int Height;
    private Image rys;

    public CPaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        Width = 320;
        Height = 360;
        rys = null;
    }

    public void AssignRys(Image xrys){
        rys = xrys;
    }

    @Override public Dimension getPreferredSize() {
        return new Dimension(320,360);
    }

    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, Width, Height);
        if(rys!=null) g.drawImage(rys, 0, 0, this);
    }
}