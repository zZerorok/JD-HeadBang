package music.comparable.sort.track;

import music.domain.dto.AlbumDTO;

import java.util.Comparator;
import music.domain.dto.TrackDTO;

public class DescArtistName implements Comparator<TrackDTO> {
    @Override
    public int compare(TrackDTO o1, TrackDTO o2) {
        int result = o2.getArtistName().compareTo(o1.getArtistName());
        return Integer.compare(result, 0);
    }
}
