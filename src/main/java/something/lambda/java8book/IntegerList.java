package something.lambda.java8book;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenyu
 * @date 2021-07-02
 */
public class IntegerList {

  public static List<Integer> getIntegerList() {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4);
    return integers;
  }
}
