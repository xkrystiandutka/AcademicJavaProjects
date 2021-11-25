package edu.lab03;

import java.util.Arrays;

public class CBusStop {
    protected String name;
    protected String[] changes = null;

    public CBusStop(String name) {
        this.name = name;
    }
    // Trzeba sprawdzic bo wtedy gdy liczba przesiadek bd pusta to podamy ta liste Strinow jako parametr konstrukotora
    public CBusStop(String name, String ...changes) {
        this.name = name;
        this.setChanges(changes);
    }

    public void setChanges(String ...changes) {
        if (changes.length > 0) {
            this.changes = changes;
        }
        else {
            this.changes = null;
        }
    }
    @Override
    public String toString() {
        return "  przystanek: " + this.name + ", przesiadki: " + ((this.changes != null) ? Arrays.toString(this.changes) : "-brak-");
    }
}
