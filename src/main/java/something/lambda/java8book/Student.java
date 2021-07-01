package something.lambda.java8book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyu
 * @date 2021-06-30
 */
public class Student {

  private String name;
  private List<Integer> score;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Integer> getScore() {
    return score;
  }

  public void setScore(List<Integer> score) {
    this.score = score;
  }

  public static List getStuList() {
    List<Student> list = new ArrayList();
    Student A = new Student();
    List<Integer> scoreA = Arrays.asList(1, 2, 3);
    A.setName("chenyu");
    A.setScore(scoreA);
    list.add(A);

    Student B = new Student();
    List<Integer> scoreB = Arrays.asList(1, 2, 3);
    B.setName("zhuo");
    B.setScore(scoreB);
    list.add(B);

    return list;
  }
}
