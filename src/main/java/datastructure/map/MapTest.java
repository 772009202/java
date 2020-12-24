package datastructure.map;

import java.util.Arrays;
import java.util.List;

/**
 * @author YuChen
 * @date 2018-12-07
 */
public class MapTest {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    list.stream().filter(item -> item > 2).forEach(System.out::println);
    System.out.println(list);
  }
}
