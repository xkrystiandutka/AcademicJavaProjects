package edu.shapes;

import java.awt.*;

public class CPolySquare extends CPoly {
    protected int A;
    protected int B;
    protected int G = 40;

    public CPolySquare(int x0, int y0, Color f, Color b, int A, int B) {
        super(x0, y0, f, b, 6);
        this.A = A;
        this.B = B;
        this.G = A / 3;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;         py[0] = Y0;
        px[1] = X0 + G;     py[1] = Y0;
        px[2] = X0 + G;     py[2] = Y0 + B - G;
        px[3] = X0 + A;     py[3] = Y0 + B - G;
        px[4] = X0 + A;     py[4] = Y0 + B;
        px[5] = X0;         py[5] = Y0 + B;
    }
}
