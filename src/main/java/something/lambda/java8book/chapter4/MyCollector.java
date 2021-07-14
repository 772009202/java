package something.lambda.java8book.chapter4;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * stream泛型意义：<br>
 * T:流中的数据 A:组合器中的类型 R:返回的类型
 *
 * @author chenyu
 * @date 2021-07-01
 */
public class MyCollector implements Collector<String, StringCombiner, String> {

  @Override
  public Supplier<StringCombiner> supplier() {
    return () -> new StringCombiner("chenyu");
  }

  @Override
  public BiConsumer<StringCombiner, String> accumulator() {
    return (a, t) -> a.setValue(a.getValue() + t);
  }

  @Override
  public BinaryOperator<StringCombiner> combiner() {
    return (x, y) -> StringCombiner.merger(x, y);
  }

  @Override
  public Function<StringCombiner, String> finisher() {
    return (e) -> e.getValue();
  }

  @Override
  public Set<Characteristics> characteristics() {
    return Collections.unmodifiableSet(
        EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
  }
}
