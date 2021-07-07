package something.lambda.java8book.chapter4;

import org.junit.Test;
import something.lambda.java8book.ListLondon;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author chenyu
 * @date 2021-07-01
 */
public class Practise4 {

  /** 使用 reduce 实现 count 方法; */
  @Test
  public void test1() {
    List<String> demo = ListLondon.getList();
    Integer count = count(1, demo.stream(), (r, t) -> r + t.length(), (r1, r2) -> r1 + r2);
    System.out.println(count);
  }

  public static <T, R> R count(
      R r, Stream<T> stream, BiFunction<R, T, R> function, BiFunction<R, R, R> function2) {
    return stream.reduce(r, (a, t) -> function.apply(a, t), (t1, t2) -> function2.apply(t1, t2));
  }
}
