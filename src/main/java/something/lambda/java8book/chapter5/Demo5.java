package something.lambda.java8book.chapter5;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import something.lambda.java8book.IntegerList;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenyu
 * @date 2021-07-02
 */
public class Demo5 {

  /**
   * 对数组的影响 <br>
   * 数组赋值
   */
  @Test
  public void test1() {
    Integer[] values = new Integer[10];
    Arrays.parallelSetAll(values, i -> i);
    System.out.println(JSONObject.toJSONString(values));
  }

  /** peek可以用来类似打印端点 */
  @Test
  public void test2() {
    List<Integer> integerList = IntegerList.getIntegerList();
    integerList.stream().peek(e -> System.out.println(e)).forEach(e -> {});
  }
}
