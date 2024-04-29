package music.comparable.sort.track50;

import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public class DescArtistName implements Comparator<HashMap<String, String>> {
    @Override
    public int compare(HashMap<String, String> track1, HashMap<String, String> track2) {
        String s = "artistName";
        Collator collator = Collator.getInstance(Locale.KOREAN);
        //        int result = track1.get(s).compareTo(track2.get(s));1
        return collator.compare(track2.get(s), track1.get(s));
//        return Integer.compare(result, 0);
    }
}
