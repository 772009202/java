package something.json;

import com.alibaba.fastjson.JSONObject;

/**
 * fastjson对于数值的接受 有小数和没小数会转成两种不同的对象（map）
 *
 * @author chenyu
 * @date 2020-12-23
 */
public class NumberTest {

  public static void main(String[] args) {
    String json = "{'num1':12, 'num2':null}";
    Num obj = JSONObject.parseObject(json, Num.class);

    System.out.println(obj);
  }
}
