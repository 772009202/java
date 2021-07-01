package something.lambda.java8book.chapter3;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import something.lambda.java8book.ListLondon;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

/**
 * @author chenyu
 * @date 2021-07-01
 */
public class Demo3 {

  /** 这个mapToInt还挺叼的 */
  @Test
  public void test1() {
    List<String> demo = ListLondon.getList();
    IntSummaryStatistics intSummaryStatistics =
        demo.stream().mapToInt(e -> e.length()).summaryStatistics();
    System.out.println(JSONObject.toJSONString(intSummaryStatistics));
    Optional<String> reduce = demo.stream().reduce((x, y) -> x + y);
  }

  /** optional */
  @Test
  public void test2() {
    List<String> demo = ListLondon.getList();
    Optional<String> reduce = demo.stream().reduce((x, y) -> "");

    Optional empty = Optional.empty();

    System.out.println(empty.isPresent());
    System.out.println(empty.orElse("c"));
    System.out.println(empty.orElseGet(() -> "chenyu"));
  }
}
