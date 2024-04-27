package Comparable;

import DTO.TrackDTO;
import java.util.Comparator;

public class AscTrackName  implements Comparator<TrackDTO> {


    @Override
    public int compare(TrackDTO o1, TrackDTO o2) {
        int result = o1.getTrackName().compareTo(o2.getTrackName()) ;
        return Integer.compare(result, 0);
    }
}

