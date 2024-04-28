package music.domain;

import music.domain.dto.AlbumDTO;

public class CartItem {
    private Integer id;
    private AlbumDTO album;
    private int quantity;

    public CartItem(AlbumDTO album) {
        this(null, album, 1);
    }

    private CartItem(Integer id, AlbumDTO album, int quantity) {
        this.id = id;
        this.album = album;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public int getQuantity() {
        return quantity;
    }
}
