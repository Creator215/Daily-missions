package daily.mission.dailymissions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetDate {
    public String get(){
        DateTimeFormatter dateTimeFormatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = null;
            String now_date = null;
            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            localDateTime = LocalDateTime.now();
            now_date = dateTimeFormatter.format(localDateTime);
            return now_date;

        }
        else {
            return "";
        }
    }
}
