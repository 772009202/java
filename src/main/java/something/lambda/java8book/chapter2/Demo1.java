package something.lambda.java8book.chapter2;

import org.junit.Test;
import something.lambda.java8book.ListLondon;
import something.lambda.java8book.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 常用的操作
 *
 * @author chenyu
 * @date 2021-06-30
 */
public class Demo1 {

  public static void main(String[] args) {
    // stream 的操作分为惰性和及早求值操作 只有执行及早求值操作才会真正的执行
    // 整个过程类似于建造者模式
    List demo = ListLondon.getList();
    demo.stream()
        .filter(
            e -> {
              System.out.println(e);
              return e.equals("london");
            });

    long count =
        demo.stream()
            .filter(
                e -> {
                  System.out.println(e);
                  return e.equals("london");
                })
            .count();
    System.out.println(count);
  }

  /** flatmap 接收stream 可以把每个元素里的集合合并到一起（split也可以 强大！！） */
  @Test
  public void test1() {
    List<Student> demo = Student.getStuList();
    List<Integer> collect =
        demo.stream()
            .map(e -> e.getScore().stream().limit(2).collect(Collectors.toList()))
            .flatMap(e -> e.stream())
            .filter(e -> e > 0)
            .collect(Collectors.toList());
    System.out.println(collect);
  }

  /** 求最小值 */
  @Test
  public void test2() {
    List<String> demo = ListLondon.getList();
    // 如果两条一样小 怎么取出两条？
    String minLength = demo.stream().min(Comparator.comparing(e -> e.length())).get();
    System.out.println(minLength);
  }

  /** reduce遍历所有元素转换 */
  @Test
  public void test3() {
    List<String> demo = ListLondon.getList();
    // 如果两条一样小 怎么取出两条？
    String minLength = demo.stream().reduce("", (x, y) -> x + y);
    String reduce = demo.stream().reduce((x, y) -> x + y).get();
    System.out.println(reduce);
  }
}
