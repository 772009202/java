package lambda.new1;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by YuChen on 2017/12/20 0020
 */
public class Test {

	public static void main(String[] args) {

		FunctionOne<String> object = (t) -> t.equals("a");

		boolean flag = object.test("b");
		System.out.println(flag);

	}

}

