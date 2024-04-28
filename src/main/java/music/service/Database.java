package music.service;

import music.domain.dto.AlbumDTO;
import music.domain.dto.TrackDTO;

import java.util.*;

public class Database {
    List<AlbumDTO> albumList = new ArrayList<>();

    public List<AlbumDTO> getAlbumList() {
        return albumList;
    }

    public Database() {

        TrackDTO track1 = new TrackDTO("(여자)아이들", "퀸카",
                "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview116/v4/01/a4/8c/01a48c35-a92a-5fde-818c-eac44bc08825/mzaf_9694690388777143301.plus.aac.p.m4a",
                "K-Pop", "2023-05-15", "1684674424");
        TrackDTO track2 = new TrackDTO("(여자)아이들", "Allergy",
                "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/36/8b/34/368b347e-8f8d-c32a-7f2e-8f1e95c987e1/mzaf_2445626033044542318.plus.aac.p.m4a",
                "K-Pop", "2023-05-15", "1684674424");
        TrackDTO track3 = new TrackDTO("(여자)아이들", "Lucid",
                "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/df/94/ce/df94cef1-d7f3-3932-3b7d-f9dfbd7d23ac/mzaf_13629516316611365075.plus.aac.p.m4a",
                "K-Pop", "2023-05-15", "1684674424");

        TrackDTO track4 = new TrackDTO("뉴진스", "ETA",
                "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview116/v4/59/6c/a7/596ca763-fc59-21be-e5c1-f3b75c5b6868/mzaf_14647956413847983060.plus.aac.p.m4a",
                "K-Pop", "2023-07-21", "1695951888");
        TrackDTO track5 = new TrackDTO("뉴진스", "Super Shy",
                "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/49/ad/b0/49adb0e9-3ccd-40ac-3e2b-e2ea803fc510/mzaf_4568736747969460913.plus.aac.p.m4a",
                "K-Pop", "2023-07-21", "1695951888");
        TrackDTO track6 = new TrackDTO("뉴진스", "New Jeans",
                "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/43/56/f6/4356f62b-f1ff-74f7-8297-d2f4925b7c31/mzaf_6245466796305117654.plus.aac.p.m4a",
                "K-Pop", "2023-07-21", "1695951888");

        albumList.add(
                new AlbumDTO("(여자)아이들", "2", 7.99, "2023-05-15", "1725271942", Arrays.asList(track1, track2, track3)));
        albumList.add(
                new AlbumDTO("뉴진스", "1", 8.00, "2023-07-21", "1695951888", Arrays.asList(track4, track5, track6)));
    }

    public List<AlbumDTO> find(List<String> albumIds) {
        return albumList; // TODO: 앨범 아이디 넣으면 찾아주는 기능 만들어주세요
    }
}

