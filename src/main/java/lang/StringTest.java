package lang;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YuChen on 2018/1/22 0022
 */
public class StringTest {

	public static void main(String[] args) {

		C a = new C("a");
		change(a);
//		System.out.print(a.a);
		System.out.println(MessageFormat.format("这是几{0},反正我是不知道的{1}", 1, 2));
		//占位符的使用
	}

	static C change(C c) {
		c = new C("b");
		return c;
	}
}

class C {
	String a ;
	C(String string) {
		a = string;
	}
}