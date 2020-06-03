package lambda.stream;

import java.util.HashMap;
import java.util.Map;

/** Created by YuChen on 2017/11/22 0022 高配 Iterator */
public class StreamStu {

  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("zhang", "1");
    map.forEach(
        (key, value) -> {
          System.out.println(key);
        });
  }
}
