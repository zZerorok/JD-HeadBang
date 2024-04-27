package music.comparable.sort.album;

import music.domain.dto.AlbumDTO;
import java.util.Comparator;

public class DescPrice implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {
        int result = 0;

        if(o2.getCollectionPrice() > o1.getCollectionPrice()){
            result = 1;
        } else if(o2.getCollectionPrice() < o1.getCollectionPrice()) {
            result = -1;
        }
        return result;
    }
}
