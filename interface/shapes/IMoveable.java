package edu.shapes;

import java.awt.*;

public interface IMoveable {
    /**
     * Przesuwa obiekt o wektor [dx, dy].
     * @param dx przesunięcie w poziomie.
     * @param dy przesunięcie w pionie.
     * */
    void moveBy(int dx, int dy);

    /**
     *
     * @param x - nowa współrzędna x
     * @param y - nowa współrzędna y
     */
    void moveTo(int x, int y);
}
