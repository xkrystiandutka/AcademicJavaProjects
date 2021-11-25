package edu.lab06;

public class CCone extends CSphere {

    @Override
    protected Double momentOfInertia() {
        return 0.3 * Mass * R * R;
    }

    public CCone(int mass, int r) {
        super(mass, r);
    }
}
