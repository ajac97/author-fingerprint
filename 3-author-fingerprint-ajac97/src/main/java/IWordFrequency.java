import java.io.File;
import java.util.Map;

public interface IWordFrequency {
    Map<Integer, Double> findWordLengthFrequency(File file);
}
