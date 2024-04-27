package music.comparable.sort.album;

import music.domain.dto.AlbumDTO;

import java.util.Comparator;

public class AscPrice implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {

        int result = 0;

        if(o1.getCollectionPrice() - o2.getCollectionPrice() > 0){
            result = 1;
        } else if (o1.getCollectionPrice() - o2.getCollectionPrice() < 0) {
            result = -1;
        }

        return result;

        //        Double result = o1.getCollectionPrice() - o2.getCollectionPrice();
        //        return Integer.compare(result, 0);
    }
}
