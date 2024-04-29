package music.comparable.sort.track;

import java.text.Collator;
import java.util.Locale;
import music.domain.dto.AlbumDTO;
import java.util.Comparator;
import music.domain.dto.TrackDTO;

public class AscArtistName implements Comparator<TrackDTO> {
    @Override
    public int compare(TrackDTO o1, TrackDTO o2) {

        Collator collator = Collator.getInstance(Locale.KOREAN);
        return collator.compare(o1.getArtistName(), o2.getArtistName());
    }
}