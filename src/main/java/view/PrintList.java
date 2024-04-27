package view;


import music.domain.dto.AlbumDTO;
import music.domain.dto.TrackDTO;

import java.util.ArrayList;
import java.util.List;

public class PrintList {

    //엘범 출력
    public void printAllList(List<AlbumDTO> list) {
        // list에 출력할 내용이 있으면 출력
        // list에 출력할 내용이 없으면 “카트가 비어있습니다” 출력
        if (list.isEmpty()) {
            System.out.println("엘범이 없습니다");
        } else {
            for (AlbumDTO album : list) {
                System.out.println(album);
            }
        }
    }
    //노래만 출력
    public void printTrack(TrackDTO track) {
        System.out.println(track);
    }

}
