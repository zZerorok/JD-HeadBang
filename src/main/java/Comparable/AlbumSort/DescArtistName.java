package Comparable;

import DTO.AlbumDTO;
import java.util.AbstractList;
import java.util.Comparator;

public class DescArtistName implements Comparator<AlbumDTO> {
    @Override
    public int compare(AlbumDTO o1, AlbumDTO o2) {
        int result = o1.getArtistName().compareTo(o2.getArtistName());
        return Integer.compare(result, 0);
    }
}
