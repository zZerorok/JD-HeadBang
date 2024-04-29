package music.comparable.sort.track50;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

public class DescReleaseDate implements Comparator<HashMap<String, String>> {
    @Override
    public int compare(HashMap<String, String> track1, HashMap<String, String> track2) {
        String s = "releaseDate";
        String date_o1 = track1.get(s);
        String date_o2 = track2.get(s);
        DateParsing(date_o2);
        DateParsing(date_o1);
        int result = track2.get(s).compareTo(track1.get(s));
        return Integer.compare(result, 0);
    }

    //ReleaseDate 데이터, String -> Date 변환
    public static void DateParsing(String date){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date redate = format.parse(date);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}