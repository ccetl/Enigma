package de.ccetl.enigma;

/**
 * @author ccetl
 */
@SuppressWarnings("SpellCheckingInspection")
public final class Walze {
    private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final WalzenNummer num;
    private final WalzenRingstellung ringPos;

    public Walze(WalzenNummer num, WalzenRingstellung ringPos) {
        this.num = num;
        this.ringPos = ringPos;
    }

    Walze(WalzenNummer num) { // for UKW with fixed pos
        this(num, WalzenRingstellung.EINS);
    }

    public char forwards(char c) {
        if (num == WalzenNummer.UKW_B) {
            char[] wiring = num.getChars();
            return wiring[getIndex(c, ALPHABET)];
        }

        int i = getIndex(c, ALPHABET);
        int index = (i + ringPos.getPos() - 1) % 26;
        return num.getChars()[index];
    }

    public char backwards(char c) {
        if (num == WalzenNummer.UKW_B) {
            return ALPHABET[getIndex(c, num.getChars())];
        }

        int i = getIndex(c, num.getChars());
        int index = (i - ringPos.getPos() + 1) % 26;
        if (index < 0) {
            index += 26;
        }
        return ALPHABET[index];
    }

    public int getIndex(char c, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings({"SpellCheckingInspection", "unused"})
    public enum WalzenNummer {
        I('E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'),
        II('A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'),
        III('B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O'),
        IV('E', 'S', 'O', 'V', 'P', 'Z', 'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T', 'G', 'K', 'D', 'C', 'M', 'W', 'B'),
        V('V', 'Z', 'B', 'R', 'G', 'I', 'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M', 'J', 'Q', 'O', 'F', 'E', 'C', 'K'),
        UKW_B('Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D', 'P', 'X', 'N', 'G', 'O', 'K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J', 'A', 'T');

        private final char[] chars;

        WalzenNummer(char... chars) {
            this.chars = chars;
        }

        public char[] getChars() {
            return chars;
        }
    }

    @SuppressWarnings({"unused", "SpellCheckingInspection"})
    public enum WalzenRingstellung {
        EINS((byte) 1),
        ZWEI((byte) 2),
        DREI((byte) 3),
        VIER((byte) 4),
        FUENF((byte) 5),
        SECHS((byte) 6),
        SIEBEN((byte) 7),
        ACHT((byte) 8),
        NEUN((byte) 9),
        ZEHN((byte) 10),
        ELF((byte) 11),
        ZWOELF((byte) 12),
        DERIZEHN((byte) 13),
        VIERZEHN((byte) 14),
        FUENFZEHN((byte) 15),
        SECHSZEHN((byte) 16),
        SIEBZEHN((byte) 17),
        ACHTZEHN((byte) 18),
        NEUNZEHN((byte) 19),
        ZWANZIG((byte) 20),
        EINUNDZWANZIG((byte) 21),
        ZWEIUNDZWANZIG((byte) 22),
        DREIUNDZWANZIG((byte) 23),
        VIERUNDZWANZIG((byte) 24),
        FUENFUNDZWANZIG((byte) 25),
        SECHSUNDZWANZIG((byte) 26);

        private final byte pos;

        WalzenRingstellung(byte pos) {
            this.pos = pos;
        }

        public byte getPos() {
            return pos;
        }
    }
}
