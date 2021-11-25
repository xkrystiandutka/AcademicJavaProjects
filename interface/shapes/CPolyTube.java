package edu.shapes;

import java.awt.*;
import java.util.Arrays;

public class CPolyTube extends CPoly {
    protected int A;
    protected int B;
    protected int G = 30;
    protected int [] dx1;
    protected int [] dy1;
    protected int [] dx2;
    protected int [] dy2;

    public CPolyTube(int x0, int y0, Color f, Color b, int A, int B) {
        super(x0, y0, f, b, 10);
        this.A = A;
        this.B = B;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;             py[0] = Y0;
        px[1] = X0 + A;         py[1] = Y0;
        px[2] = X0 + A;         py[2] = Y0 + B;
        px[3] = X0;             py[3] = Y0 + B;
        px[4] = X0;             py[4] = Y0;
        px[5] = X0 + G;         py[5] = Y0 + G;
        px[6] = X0 + A - G;     py[6] = Y0 + G;
        px[7] = X0 + A - G;     py[7] = Y0 + B - G;
        px[8] = X0 + G;         py[8] = Y0 + B - G;
        px[9] = X0 + G;         py[9] = Y0 + G;

        dx1 = Arrays.copyOfRange(px, 0, 5);
        dx2 = Arrays.copyOfRange(px, 5, 10);
        dy1 = Arrays.copyOfRange(py, 0, 5);
        dy2 = Arrays.copyOfRange(py, 5, 10);
    }

    @Override
    protected void drawShape(Graphics2D g2d) {
        updateCoordinates();
        g2d.setColor(fillColor);
        g2d.fillPolygon(px, py, pointCount);
        g2d.setColor(borderColor);
        g2d.drawPolygon(dx1, dy1, pointCount / 2);
        g2d.drawPolygon(dx2, dy2, pointCount / 2);
    }
}
