package Comparable;

import DTO.TrackDTO;
import java.util.Comparator;

public class DescTrackName  implements Comparator<TrackDTO> {


    @Override
    public int compare(TrackDTO o1, TrackDTO o2) {
        int result = o2.getTrackName().compareTo(o1.getTrackName()) ;
        return Integer.compare(result, 0);
    }
}
