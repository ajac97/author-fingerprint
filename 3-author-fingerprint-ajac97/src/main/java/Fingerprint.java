import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fingerprint implements IWordFrequency {

    public Map<Integer, Double> findWordLengthFrequency(File file) {
        try (Scanner sc = new Scanner(file)) {
            int[] wordLengths = new int[20];
            double words = 0;
            while (sc.hasNext()) {
                words++;
                String str = sc.next().replaceAll("[^a-zA-Z0-9]", "");// removes all non-alphanumeric characters
                if (str.length() > 0) {
                    wordLengths[str.length() - 1]++;
                }
            }
            Map<Integer, Double> frequencies = new HashMap();
            for (int i = 0; i < wordLengths.length; i++) {
                frequencies.put(i + 1, wordLengths[i] / words);
            }
            return frequencies;

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        return null;
    }

    public void fingerprintFileOutput(File file, String name) {
        try (PrintWriter pw = new PrintWriter(new File(name + "Analysis.txt"))) {
            Map<Integer, Double> frequencies = findWordLengthFrequency(file);
            pw.println("Length\tFrequency");
            for (Map.Entry<Integer, Double> entry : frequencies.entrySet()) {
                pw.println(entry.getKey() + ":\t " + entry.getValue());

            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }

    }
}

