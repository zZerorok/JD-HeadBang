package music.ui.console;


import music.domain.CartItem;
import music.domain.dto.AlbumDTO;
import music.domain.dto.TrackDTO;

import java.util.HashMap;
import java.util.List;

public class PrintList {
    public static String formatAlbum(AlbumDTO album) {
        StringBuilder sb = new StringBuilder();
        sb.append("가수 : ").append(album.getArtistName())
                .append(", 앨범이름 : ").append(album.getCollectionName())
                .append(", 가격 : ").append(album.getCollectionPriceKRW())
                .append(", 노래목록 : [");

        for (TrackDTO track : album.getTrackTs()) {
            sb.append(formatTrack(track)).append(", ");
        }

        sb.append("]");
        return sb.toString();
    }

    public static String formatCart(CartItem item) {
        StringBuilder sb = new StringBuilder();
        sb.append("장바구니id : ").append(item.getId())
                .append(", 앨범이름 : ").append(item.getAlbum().getCollectionName())
                .append(", 앨범가격 : ").append(item.getAlbum().getCollectionPriceKRW());
        return sb.toString();
    }

    public static String formatTrack(TrackDTO track) {
        return track.getArtistName() + " - " + track.getTrackName();
    }

    public List<TrackDTO> printTrack(List<TrackDTO> list) {
        if (list.isEmpty()) {
            System.out.println("노래가 없습니다");
        } else {
            for (int i = 0; i < list.size(); i++) {
                TrackDTO track = list.get(i);
                System.out.println((i + 1) + ". " + formatTrack(track)); // 트랙 번호와 내용 출력
            }
        }
        return list;
    }
    public void printAlbum(AlbumDTO album) {
        System.out.println(formatAlbum(album));
    }

    public List<CartItem> printCart(List<CartItem> item) {
        if (item.isEmpty()) {
            System.out.println("장바구니가 비었습니다");
        } else {
            for (int i = 0; i < item.size(); i++) {
                CartItem cart = item.get(i);
                System.out.println((i + 1) + ". " + formatCart(cart)); // 트랙 번호와 내용 출력
            }
        }
        return item;
    }

    public void displayTopTracks(List<HashMap<String, String>> topTracks) {
        if (topTracks.isEmpty()) {
            System.out.println("No tracks available.");
            return;
        }

        System.out.println("Top 50 Tracks:");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-30s %-40s %-15s%n", "가수", "노래이름", "발매날짜");
        System.out.println("----------------------------------------------------------------------------------");

        for (HashMap<String, String> track : topTracks) {
            String artistName = track.get("artistName");
            String trackName = track.get("trackName");
            String releaseDate = track.get("releaseDate");

            System.out.printf("%-30s %-40s %-15s%n", artistName, trackName, releaseDate);
        }

        System.out.println("----------------------------------------------------------------------------------");
    }


}
