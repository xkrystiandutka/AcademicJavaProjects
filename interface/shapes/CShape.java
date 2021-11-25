package edu.shapes;

import java.awt.*;

public abstract class CShape implements IShape {
    protected int X0;
    protected int Y0;
    protected int offsetX;
    protected int offsetY;
    protected Color fillColor;
    protected Color borderColor;

    public CShape(int x0, int y0, Color f, Color b) {
        this.X0 = x0;
        this.Y0 = y0;
        this.fillColor = f;
        this.borderColor = b;
    }

    protected abstract boolean isPointInside(int xk, int yk);
    /**
     * Funkcja służy do odrysowania kształtu  figury na powierzchni
     * Graphics2D, względem punktu X0, Y0
     * @param g2d - powierzchnia do odrysowania figury
     */
    protected abstract void drawShape(Graphics2D g2d);

    @Override
    public void draw(Graphics graphics, boolean selected) {
        Graphics2D g2d = (Graphics2D) graphics;
        if (!selected) {
            g2d.setStroke(new BasicStroke(2));
        } else {
            g2d.setStroke(new BasicStroke(5));
        }
        drawShape(g2d);
    }

    @Override
    public void moveBy(int dx, int dy) {
        X0 += dx - offsetX;
        Y0 += dy - offsetY;
    }

    @Override
    public void moveTo(int x, int y) {
        X0 = x - offsetX;
        Y0 = y - offsetY;
    }

    @Override
    public boolean select(int xk, int yk) {
        boolean res = isPointInside(xk, yk);
        if (res) {
            offsetX = xk - X0;
            offsetY = yk - Y0;
        } else {
            offsetX = 0;
            offsetY = 0;
        }
        return res;
    }
}
