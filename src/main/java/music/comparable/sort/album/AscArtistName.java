package music.comparable.sort.album;

import music.domain.dto.AlbumDTO;
import java.util.Comparator;

public class AscArtistName implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {
        int result = o2.getArtistName().compareTo(o1.getArtistName());
        return Integer.compare(result, 0);
    }
}