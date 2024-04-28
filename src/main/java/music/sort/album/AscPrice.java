package music.sort.album;

import music.domain.dto.AlbumDTO;

import java.util.Comparator;

public class AscPrice implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {
        return (int) (o1.getCollectionPriceUSD() * 1377.93 - o2.getCollectionPriceUSD() * 1377.93);
    }
}
