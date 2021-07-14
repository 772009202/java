package something.lambda.java8book;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyu
 * @date 2021-07-01
 */
public class CacheMap {

  public static Map getMap() {
    Map<String, String> map = new HashMap();
    map.put(null, "null");
    map.put("chenyu", "chenyu");
    map.put("zhuo", "zhuo");

    return map;
  }
}
