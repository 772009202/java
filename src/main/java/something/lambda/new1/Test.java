package something.lambda.new1;

/** Created by YuChen on 2017/12/20 0020 */
public class Test {

  public static void main(String[] args) {

    //		FunctionOne<String> object = (t) -> t.equals("a");

    FunctionOne<String> object = TestMethod::test;
    boolean flag = object.test("b");
    System.out.println(flag);
  }
}

class TestMethod {
  public static boolean test(String chr) {
    return "b".equals(chr);
  }
}
