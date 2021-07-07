package something.lambda.java8book;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成测试实体
 *
 * @author chenyu
 * @date 2021-06-30
 */
public class ListLondon {

  public static List getList() {
    List<String> list = new ArrayList();
    list.add("london");
    list.add("chen");
    list.add("london");
    list.add("london2");
    list.add("");
    return list;
  }
}
