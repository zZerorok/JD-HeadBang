package Comparable;

import DTO.AlbumDTO;
import DTO.TrackDTO;
import java.util.ArrayList;
import java.util.List;

public class arrayRun {
    public static void main(String[] args) {
        ArrayList<AlbumDTO> arrayList = new ArrayList<>();
        List<AlbumDTO> trackList = List();
        arrayList.add(new AlbumDTO("나는간다", "나는간다1" , 25000.0, "202402", "1", trackList));
        System.out.println(arrayList);
    }

}
