package test;

import java.math.BigDecimal;

/**
 * Created by YuChen on 2017/10/26
 */
public class Test8 {
	public static void main(String[] args) {

	}
	static String test(int num) {
		String str = "";
		int num2 = num%10;
		if (num2 >= 1) {
			str = num2 + test(num/10);
		}
		return str;
	}
}
