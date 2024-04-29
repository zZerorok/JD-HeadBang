package music.ui.console;


import music.domain.CartItem;
import music.domain.dto.AlbumDTO;
import music.domain.dto.TrackDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PrintList {
    public static String formatAlbum(AlbumDTO album) {
        StringBuilder sb = new StringBuilder();
        sb.append("가수 : ").append(album.getArtistName())
                .append(", 엘범이름 : ").append(album.getCollectionName())
                .append(", 가격 : ").append(album.getCollectionPriceKRW())
                .append(", 노래목록 : ");
        String tracks = album.getTrackTs().stream()
                .map(PrintList::formatTrack)
                .collect(Collectors.joining(", ", "[", "]"));
        sb.append(tracks);
        return sb.toString();
    }

    public static String formatCart(CartItem item) {
        return "장바구니 id : " + item.getId() +
                ", 앨범이름 : " + item.getAlbum().getCollectionName() +
                ", 앨범가격 : " + item.getAlbum().getCollectionPriceKRW();
    }

    public static String formatTrack(TrackDTO track) {
        return track.getArtistName() + " - " + track.getTrackName() + ", 앨범 ID: " + track.getCollectionId();
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

    public void displayTopTracks(List<TrackDTO> topTracks) {
        if (topTracks.isEmpty()) {
            System.out.println("No tracks available.");
            return;
        }

        System.out.println("--------------------------------🎉🎊 TOP 50곡 🏆🎖️-------------------------------");
        System.out.println("⭐〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰〰️〰️〰️〰〰️〰️〰️⭐");
        System.out.printf("%-30s %-40s %-15s %-15s%n", "가수", "노래이름", "발매날짜", "앨범 ID");
        System.out.println("⭐〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️⭐");

        for (TrackDTO track : topTracks) {
            String artistName = track.getArtistName();
            String trackName = track.getTrackName();
            String releaseDate = track.getReleaseDate();
            String albumId = track.getCollectionId();
            System.out.printf("%-30s %-40s %-15s %-15s%n", artistName, trackName, releaseDate, albumId);
        }

        System.out.println("⭐〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰〰️〰️〰️〰〰️〰️〰️〰⭐");
    }
}
