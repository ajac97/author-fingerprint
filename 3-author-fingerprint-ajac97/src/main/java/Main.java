import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Fingerprint myFingerprinter = new Fingerprint();
        myFingerprinter.fingerprintFileOutput(new File("Hamlet.txt"), "Hamlet");
        myFingerprinter.fingerprintFileOutput(new File("Macbeth.txt"), "Macbeth");
        myFingerprinter.fingerprintFileOutput(new File("TaleOfTwoCities.txt"), "TaleOfTwoCities");
        myFingerprinter.fingerprintFileOutput(new File("GreatExpectations.txt"), "GreatExpectations");
    }
}
