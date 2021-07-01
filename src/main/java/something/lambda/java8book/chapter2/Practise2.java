package something.lambda.java8book.chapter2;

import org.junit.Test;
import something.lambda.java8book.ListLondon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyu
 * @date 2021-06-30
 */
public class Practise2 {

  /** reduce实现map功能 -> stream流汇聚 1.参数1 汇聚的类型（也可以当作初始值） 2.参数2 如何汇聚 3.参数3 并行之间的元素如何汇聚 */
  @Test
  public void test1() {
    List<String> demo = ListLondon.getList();
    List<String> newOne = map(demo.stream(), e -> e + "11").collect(Collectors.toList());
    for (int i = 0; i < newOne.size(); i++) {
      System.out.println(newOne.get(i));
    }
  }

  /** reduce实现filter功能 */
  @Test
  public void test2() {
    List<String> demo = ListLondon.getList();
    List<String> newOne =
        filter(demo.stream(), e -> e.equals("london")).collect(Collectors.toList());
    System.out.println(newOne);
  }

  public <T, R> Stream<R> map(Stream<T> stream, Function<T, R> fun) {
    return stream.reduce(
        new ArrayList<R>().stream(),
        (u, t) -> Stream.concat(u, Stream.of(fun.apply(t))),
        (a, b) -> Stream.concat(a, b));
  }

  public <T> Stream<T> filter(Stream<T> stream, Predicate<? super T> predicate) {
    return stream.reduce(
        new ArrayList<T>().stream(),
        (u, t) -> Stream.concat(predicate.test(t) ? Stream.of(t) : new ArrayList<T>().stream(), u),
        (a, b) -> Stream.concat(a, b));
  }
}
