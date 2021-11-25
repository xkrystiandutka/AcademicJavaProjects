package edu.shapes;

import java.awt.*;

public interface IDrawable {
    /**
     * Rysuje obiekt
     * @param graphics obszar graficzny na którym zostanie odrysowany obiekt
     * @param selected informuje, czy dany obiekt jest aktualnie zaznaczony
     */
    void draw(Graphics graphics, boolean selected);
}
