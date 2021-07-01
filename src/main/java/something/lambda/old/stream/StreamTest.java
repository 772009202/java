package something.lambda.old.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by YuChen on 2018/5/30 0030
 *
 * <p>stream 利用多核 处理速度快
 *
 * <p>三种操作:Intermediate Terminal Short-circuiting terminal只能处理一次 一次处理完便终止流
 */
public class StreamTest {

  /** map做的是 对元素的操作 */
  @Test
  public void demo1() {
    List<Integer> list = new ArrayList();
    list.add(1);
    list.add(3);
    /** 这个map是一对一 */
    list.stream().map((e) -> e = e * e).forEach((e) -> System.out.println(e));
    List<Integer> resultList = list.stream().map((e) -> e * e).collect(Collectors.toList());
  }

  @Test
  public void demo2() {
    Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5))
        .flatMap((e) -> e.stream())
        .forEach((e) -> System.out.println(e));
  }

  /** filter的用法 做的是对元素的筛选 */
  @Test
  public void demo3() {
    Integer[] integers = {1, 2, 3, 5};
    Integer[] arrays = Stream.of(integers).filter((e) -> e % 2 == 0).toArray(Integer[]::new);
    Arrays.stream(arrays).forEach((e) -> System.out.println(e));
    Arrays.stream(arrays).peek((e) -> System.out.println(e)).count();
  }

  @Test
  public void demo4() {
    Map<String, Object> map = new HashMap<>();
    map.put("1", "2");
    map.put("2", "3");
    //		Stream.of(map).forEach( e -> System.out.println(e));
    //		map.entrySet().stream().forEach(e -> System.out.println(e));
    System.out.println(map.entrySet().stream().anyMatch(e -> e.getKey().equals("2")));
  }
}
