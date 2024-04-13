import de.ccetl.enigma.Enigma;
import de.ccetl.enigma.Kabel;
import de.ccetl.enigma.Steckerbrett;
import de.ccetl.enigma.Walze;

public class Main {
    public static void main(String[] args) {
        Steckerbrett steckerbrett = new Steckerbrett(new Kabel('A', 'H'), new Kabel('B', 'Q'), new Kabel('C', 'R'), new Kabel('D', 'S'), new Kabel('E', 'T'));
        Enigma enigma = new Enigma(new Walze(Walze.WalzenNummer.II, Walze.WalzenRingstellung.VIER), new Walze(Walze.WalzenNummer.V, Walze.WalzenRingstellung.EINS), new Walze(Walze.WalzenNummer.II, Walze.WalzenRingstellung.SECHSUNDZWANZIG), steckerbrett);
        String s = "HalloWelt";
        System.out.println(s);
        s = enigma.verschluesseln(s);
        System.out.println("Verschluesselt: " + s);
        s = enigma.verschluesseln(s);
        System.out.println("Entschluesselt: " + s);
    }
}
