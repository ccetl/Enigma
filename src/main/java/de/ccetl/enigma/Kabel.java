package de.ccetl.enigma;

/**
 * @author ccetl
 */
public final class Kabel {
    private final char c1;
    private final char c2;

    public Kabel(char buchstabe1, char buchstabe2) {
        this.c1 = buchstabe1;
        this.c2 = buchstabe2;
    }

    public char connect(char c) {
        if (c == c1) {
            return c2;
        } else if (c == c2) {
            return c1;
        }

        return c;
    }

    public char getC1() {
        return c1;
    }

    public char getC2() {
        return c2;
    }
}
