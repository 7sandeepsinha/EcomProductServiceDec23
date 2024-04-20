import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String timeStamp = "2024-04-16T02:00:00+0530";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        try {
            Date date = sdf.parse(timeStamp);
            System.out.println("Date: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
/*
    Date -> never stores a specific date or time or timezone
    Date -> stores number of seconds that have passed since 1 Jan 1970, 00:00 at GMT || epoch time

    int epoch - 1970 to 2038
    long epoch - 1970 to 20.8M years


 */