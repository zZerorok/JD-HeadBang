package music.comparable.sort.album;

import java.util.Comparator;
import music.domain.dto.AlbumDTO;

public class DescCollectionName implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {
        int result = o1.getCollectionName().compareTo(o2.getCollectionName());
        return Integer.compare(result, 0);
    }
}