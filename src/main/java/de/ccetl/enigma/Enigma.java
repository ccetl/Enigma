package de.ccetl.enigma;

import java.util.Locale;

/**
 * An Enigma N.
 * <br>
 * Used resources: <a href="https://kryptografie.de/kryptografie/chiffre/enigma.htm">kryptografie.de</a>, <a href="https://de.wikipedia.org/wiki/Enigma_(Maschine)">Wikipedia/Enigma</a>
 *
 * @author ccetl
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Enigma {
    private final Steckerbrett plugboard;
    private final Walze cylinder1;
    private final Walze cylinder2;
    private final Walze cylinder3;
    private final Walze ukw;

    public Enigma(Walze walze1, Walze walze2, Walze walze3, Steckerbrett plugboard) {
        this.plugboard = plugboard;
        this.cylinder1 = walze1;
        this.cylinder2 = walze2;
        this.cylinder3 = walze3;
        this.ukw = new Walze(Walze.WalzenNummer.UKW_B);
    }

    public char verschluesseln(char c) {
        c = plugboard.connect(c);
        c = cylinder1.scramble(c);
        c = cylinder2.scramble(c);
        c = cylinder3.scramble(c);
        c = ukw.scramble(c);
        c = cylinder3.unScramble(c);
        c = cylinder2.unScramble(c);
        c = cylinder1.unScramble(c);
        c = plugboard.connect(c);
        return c;
    }

    public String verschluesseln(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toUpperCase(Locale.ROOT).toCharArray()) {
            sb.append(verschluesseln(c));
        }
        return sb.toString();
    }
}
