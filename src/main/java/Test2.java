import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenyu
 * @date 2021-06-21
 */
public class Test2 {

  public static void main(String[] args) {
    List<Person> list = new ArrayList<>();

    Person p1 = new Person();
    List<Goal> gs1 = new ArrayList<>();
    Goal g1 = new Goal();
    g1.setName("cy1");
    Goal g2 = new Goal();
    g2.setName("cy2");
    gs1.add(g1);
    gs1.add(g2);
    p1.setName("陈雨1");
    p1.setList(gs1);
    list.add(p1);

    Person p2 = new Person();
    List<Goal> gs2 = new ArrayList<>();
    Goal g3 = new Goal();
    g3.setName("cy1");
    gs2.add(g3);
    p2.setName("陈雨2");
    p2.setList(gs2);
    list.add(p2);

    Person p3 = new Person();
    p3.setName("陈雨2");
    list.add(p3);
    Map map = list.stream().collect(Collectors.groupingBy(Person::getName));
    System.out.println(JSONObject.toJSONString(map));

    //    System.out.println(JSONObject.toJSONString(list));
    //    list = list.stream().skip(1 * 0).limit(1).collect(Collectors.toList());
    //    System.out.println(JSONObject.toJSONString(list));
  }
}

class Person {

  String name;
  List<Goal> list;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Goal> getList() {
    return list;
  }

  public void setList(List<Goal> list) {
    this.list = list;
  }
}

class Goal {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
