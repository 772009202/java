package java_.thread.five;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** Created by YuChen on 2017/10/13 0013 */
public class TimerStu {

  public static Timer timer = new Timer(true);

  static class Task extends TimerTask {

    @Override
    public void run() {
      System.out.println("-----运行了,时间：" + new Date());
    }
  }

  public static void main(String[] args) throws ParseException {
    Task task = new Task();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = "2017-10-13 16:19:00";
    System.out.println("-----当前时间");
    Date time = sdf.parse(date);
    timer.schedule(task, time);
  }
}
