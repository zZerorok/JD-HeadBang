package music.comparable.sort.album;

import music.domain.dto.AlbumDTO;
import java.util.Comparator;

public class DescPrice implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {
        return (int) (o2.getCollectionPriceUSD() * 1377.93 - o1.getCollectionPriceUSD() * 1377.93);
    }
}
