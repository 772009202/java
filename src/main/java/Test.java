import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author chenyu
 * @date 2021-06-02
 */
public class Test {

  private static DateTimeFormatter dateTimeFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String nowStr = formatter.format(date);
    long time =
        LocalDateTime.from(dateTimeFormatter.parse(nowStr))
            .toInstant(ZoneOffset.UTC)
            .toEpochMilli();
    Date date1 = new Date(time);
    System.out.println(date1);

    Date date2 = formatter.parse("2021-06-11 14:25:00");
    System.out.println(date2);

    Date date3 = new Date();
    System.out.println(date3);
  }
}
