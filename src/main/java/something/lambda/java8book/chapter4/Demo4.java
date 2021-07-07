package something.lambda.java8book.chapter4;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import something.lambda.java8book.CacheMap;
import something.lambda.java8book.ListLondon;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 收集器collect
 *
 * @author chenyu
 * @date 2021-07-01
 */
public class Demo4 {

  /** 求最小值，支持收集器去做 */
  @Test
  public void test1() {
    List<String> demo = ListLondon.getList();
    Optional<String> collect =
        demo.stream().collect(Collectors.minBy(Comparator.comparing(e -> e.length())));
    System.out.println(collect.orElse(""));

    String min2 = demo.stream().min(Comparator.comparing(e -> e.length())).orElse("");
    System.out.println(min2);
  }

  @Test
  public void test2() {
    List<String> demo = ListLondon.getList();

    Double ave = demo.stream().collect(Collectors.averagingInt(e -> e.length()));
    System.out.println(ave);
  }

  /** 根据判断器将流分成false、true两组新的集合 */
  @Test
  public void test3() {
    List<String> demo = ListLondon.getList();

    Map<Boolean, List<String>> groupByLondon =
        demo.stream().collect(Collectors.partitioningBy(e -> e.equals("london")));
    groupByLondon.forEach((e, k) -> k.forEach(str -> System.out.println(e + ":" + str)));
  }

  /** 字符串拼接 */
  @Test
  public void test4() {
    List<String> demo = ListLondon.getList();

    String joinStr =
        demo.stream()
            .filter(e -> !e.equals("london") && !e.equals(""))
            .collect(Collectors.joining(",", "[", "]"));
    System.out.println(joinStr);
  }

  /** 分组计数 */
  @Test
  public void test5() {
    List<String> demo = ListLondon.getList();

    Map<Integer, Long> group =
        demo.stream().collect(Collectors.groupingBy(e -> e.length(), Collectors.counting()));
    group.forEach((v, k) -> System.out.println(v + ":" + k));
  }

  /** 分组 返回的集合也可以替换 */
  @Test
  public void test6() {
    List<String> demo = ListLondon.getList();

    Map<Integer, List<String>> collect =
        demo.stream()
            .collect(
                Collectors.groupingBy(
                    e -> e.length(), Collectors.mapping(e -> e + "group", Collectors.toList())));
    System.out.println(JSONObject.toJSONString(collect));
  }

  /** 自定义收集器 */
  @Test
  public void test7() {
    List<String> demo = ListLondon.getList();
    String collect = demo.stream().collect(new MyCollector());
    System.out.println(collect);
  }

  /** lambda对map的操作影响 */
  @Test
  public void test8() {
    Map<String, String> map = CacheMap.getMap();
    String value = map.computeIfAbsent("chenyu", (e) -> "test");
    String value2 = map.computeIfAbsent("test", (e) -> "test");
    System.out.println();
  }
}
