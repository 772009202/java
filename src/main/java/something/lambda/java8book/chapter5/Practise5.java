package something.lambda.java8book.chapter5;

import org.junit.Test;
import something.lambda.java8book.IntegerList;

import java.util.List;
import java.util.Optional;

/**
 * @author chenyu
 * @date 2021-07-02
 */
public class Practise5 {

  @Test
  public void test1() {
    List<Integer> integerList = IntegerList.getIntegerList();
    Optional<Integer> optionalInteger =
        integerList.stream().parallel().map(e -> e * e).reduce((x, y) -> x + y);
    System.out.println(optionalInteger.orElse(null));
  }

  @Test
  public void test2() {
    List<Integer> integerList = IntegerList.getIntegerList();
    Integer reduce = integerList.stream().reduce(5, (x, y) -> x * y);
    System.out.println(reduce);
  }

  @Test
  public void test3() {
    List<Integer> integerList = IntegerList.getIntegerList();
    Integer reduce = integerList.parallelStream().reduce(0, (x, y) -> x + y * y, (x, y) -> x + y);
    System.out.println(reduce);
  }
}
