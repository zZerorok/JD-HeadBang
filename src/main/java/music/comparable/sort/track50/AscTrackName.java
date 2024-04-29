package music.comparable.sort.track50;

import java.util.Comparator;
import java.util.HashMap;

public class AscTrackName implements Comparator<HashMap<String, String>> {
    @Override
    public int compare(HashMap<String, String> track1, HashMap<String, String> track2) {
        String s = "trackName";
        int result = track1.get(s).compareTo(track2.get(s));
        return Integer.compare(result, 0);
    }
}
