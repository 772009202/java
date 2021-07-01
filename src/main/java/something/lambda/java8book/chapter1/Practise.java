package something.lambda.java8book.chapter1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenyu
 * @date 2021-06-30
 */
public class Practise {

  public static void main(String[] args) {
    // ThreadLocal 适用于每个线程需要自己独立的实例且该实例需要在多个方法中被使用，也即变量在线程间隔离而在方法或类间共享的场景
    // ThreadLocal 在同一县城的链路中 可以直接获取值 类似于静态变量
    ThreadLocal threadLocal = ThreadLocal.withInitial(() -> new Object());

    // DateFormatter 类是非线程安全的。使用构造函数创建一个线程安全的 DateFormatter
    // 对象，并输出日期，如“01-Jan-1970”
    ThreadLocal<DateFormat> synDateFormat =
        ThreadLocal.withInitial(() -> new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"));
    DateFormat format = synDateFormat.get();
    System.out.println(format.format(new Date()));
  }
}
