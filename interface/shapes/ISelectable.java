package edu.shapes;

public interface ISelectable {
    /**
     * Sprawdzenie punktu (xk, yk)
     * @param xk - współrzędna X sprawdzanego punktu
     * @param yk - współrzędna Y sprawdzanego punktu
     * @return odpowiedź, czy punkt leży wewnątrz konturu obiektu
     */
    boolean select(int xk, int yk);
}
