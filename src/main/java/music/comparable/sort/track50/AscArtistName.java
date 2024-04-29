package music.comparable.sort.track50;

import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public class AscArtistName implements Comparator<HashMap<String, String>> {
    @Override
    public int compare(HashMap<String, String> track1, HashMap<String, String> track2) {
        String s = "artistName";
//        int result = track1.get(s).compareTo(track2.get(s));
        Collator collator = Collator.getInstance(Locale.KOREAN);
        return collator.compare(track1.get(s), track2.get(s));
    }
}
