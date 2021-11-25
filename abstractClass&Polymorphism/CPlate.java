package edu.lab06;

public class CPlate extends CSphere {

    @Override
    protected Double momentOfInertia() {
        return 0.5 * Mass * R * R;
    }

    public CPlate(int mass, int r) {
        super(mass, r);
    }
}
