package something.lambda.java8book.chapter4;

/**
 * @author chenyu
 * @date 2021-07-01
 */
public class StringCombiner {

  private String value;

  public StringCombiner() {}

  public StringCombiner(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public static void add(StringCombiner combiner, String joinStr) {
    combiner.setValue(combiner.getValue() + "," + joinStr);
  }

  public static StringCombiner merger(StringCombiner combiner, StringCombiner combiner2) {
    return new StringCombiner(combiner.getValue() + "," + combiner2.getValue());
  }
}
