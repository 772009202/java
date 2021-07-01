package something.lambda;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author chenyu
 * @date 2021-06-28
 */
public class Test {

  public static void main(String[] args) {
    int[] a = {1};
    int b = 1;
    Predicate p = e -> a[0] > b;
    new ArrayList<>()
        .stream()
            .forEach(
                e -> {
                  a[0]++;
                });

    BinaryOperator<Long> text = (x, y) -> x + y;
    ThreadLocal threadLocal = ThreadLocal.withInitial(() -> new ThreadLocal());
  }
}
