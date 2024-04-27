package music;

import music.domain.dto.AlbumDTO;
import music.domain.dto.TrackDTO;

import java.util.ArrayList;
import java.util.List;

public class ArrayRun {
    public static void main(String[] args) {
        ArrayList<AlbumDTO> arrayList = new ArrayList<>();
        List<TrackDTO> trackList = new ArrayList<>();
        arrayList.add(new AlbumDTO("나는간다", "나는간다1" , 25000.0, "202402", "1", trackList));
        System.out.println(arrayList);
    }

}
