package something.lambda.java8book.chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenyu
 * @date 2021-07-01
 */
public class Practise3 {

  /** 这个mapToInt还挺叼的 */
  @Test
  public void test1() {
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    List<Integer> numbers_ = numbers.stream().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(1, 2, 3), numbers_);

    Set<Integer> setNum = new HashSet<>(Arrays.asList(1, 2, 3));
    List<Integer> setNum_ = setNum.stream().collect(Collectors.toList());
    Assert.assertEquals(Arrays.asList(1, 2, 3), setNum_);
  }
}
