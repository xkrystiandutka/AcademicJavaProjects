package edu.shapes;

import java.awt.*;

public class CPolyTBar extends CPoly {
    protected int A;
    protected int H;
    protected int G = 40;

    public CPolyTBar(int x0, int y0, Color f, Color b, int A, int H) {
        super(x0, y0, f, b, 8);
        this.A = A;
        this.H = H;
        this.G = A / 3;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;                         py[0] = Y0;
        px[1] = X0 + A;                     py[1] = Y0;
        px[2] = X0 + A;                     py[2] = Y0 + G;
        px[3] = X0 + (A / 2) + (G / 2);     py[3] = Y0 + G;
        px[4] = X0 + (A / 2) + (G / 2);     py[4] = Y0 + H;
        px[5] = X0 + (A / 2) - (G / 2);     py[5] = Y0 + H;
        px[6] = X0 + (A / 2) - (G / 2);     py[6] = Y0 + G;
        px[7] = X0;                         py[7] = Y0 + G;
    }
}
