package music.domain;

import java.util.ArrayList;
import java.util.List;

// TODO: 카트 DB 저장소가 필요?
public class Cart {
    private Long id;
    private final List<Album> albums = new ArrayList<>();

    public void put(List<Album> albums) {
        this.albums.addAll(albums);
    }
}
