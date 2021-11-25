package edu.lab06;

public class CCylinder extends CCone {
    @Override
    protected Double momentOfInertia() {
        return 0.5 * Mass * R * R;
    }

    public CCylinder(int mass, int r) {
        super(mass, r);
    }
}
