package view;

import DTO.AlbumDTO;

import java.util.ArrayList;

public class PrintList {

    public void printAllList(ArrayList<AlbumDTO> list) {
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

}
