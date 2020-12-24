package lambda.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyu
 * @date 2020-05-28
 */
public class StreamStu_20200528 {

  /** stream.map() 返回新的元素 T->R */
  @Test
  public void test() {
    // map的stream，有点奇怪啊
    Map<String, String> map = new HashMap(10);
    map.put("1", "1");
    map.put("2", "2");
    map.put("3", "3");
    Stream.of(map)
        .map(
            e -> {
              String result = "";
              for (String el : e.keySet()) {
                result += e.get(el);
              }
              return result;
            })
        .forEach(System.out::println);

    Stream.of("11", "22", "33", "44").map(e -> e.length()).forEach(e -> System.out.println(e));
  }

  /** flatMap 将元素扁平化 */
  @Test
  public void test2() {
    Stream.of("1,1", "2,2", "3,3", "4,4")
        .flatMap(e -> Stream.of(e.split(",")))
        .forEach(System.out::println);

    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    // 获取对应的平方数
    //    List<Integer> squaresList =
    numbers.stream()
        .map(i -> i * i)
        .distinct()
        .collect(Collectors.toList())
        .forEach(System.out::println);
  }

  /** collections.map() list转换为map */
  @Test
  public void test3() {
    List<Student> stus = new ArrayList<>();
    stus.add(new Student("chenyu", 26));
    stus.add(new Student("zhuo", 25));
    stus.add(new Student("bao", 24));

    Map<String, Object> map = stus.stream().collect(Collectors.toMap(e -> e.getName(), e -> e));
    System.out.println(map);
  }

  class Student {
    String name;
    int age;

    public Student(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
  }
}
