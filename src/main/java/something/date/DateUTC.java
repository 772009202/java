package something.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chenyu
 * @date 2021-05-31
 */
public class DateUTC {

  public static void main(String[] args) throws ParseException {
    // 获取当前时间
    LocalDateTime currentTime = LocalDateTime.now();
    System.out.println("当前时间：  " + currentTime);

    // 把当前时间转成当前日期。比如:2019-10-1
    LocalDate date1 = currentTime.toLocalDate();
    System.out.println("date1 = " + date1);

    // 把当前年换成2012年月换成10月
    LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
    System.out.println("date2 = " + date2);

    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    date = sdf.parse("2021-06-01 15:24:00");
    System.out.println("UTC时间: " + date);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
    // calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
    System.out.println("北京时间: " + calendar.getTime());
  }
}
