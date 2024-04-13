package de.ccetl.enigma;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ccetl
 */
public final class Steckerbrett {
    private final Kabel[] plugs;

    public Steckerbrett(Kabel... kabel) {
        if (kabel.length > 10) {
            throw new RuntimeException("Steckerbrett: Das Steckerbrett hat nur 10 Kabel!");
        }
        plugs = kabel;
        Set<Character> used = new HashSet<>();
        for (Kabel plug : plugs) {
            if (!used.add(plug.getC1()) || !used.add(plug.getC2())) {
                throw new RuntimeException("Steckerbrett: Jeder Buchstabe kann nur einmal verwendet werden!");
            }
        }
    }

    protected char connect(char c) {
        for (Kabel plug : plugs) {
            c = plug.connect(c);
        }
        return c;
    }
}
