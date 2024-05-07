package music.infrastructure;

import music.domain.MyAlbum;

import java.util.HashMap;
import java.util.Map;

public class MyAlbums {
    private final Map<String, MyAlbum> myAlbumMap = new HashMap<>();

    public void addMyAlbum(String id, MyAlbum album) {
        myAlbumMap.put(id, album);
    }

    public MyAlbum getMyAlbum(String id) {
        return myAlbumMap.get(id);
    }
}
