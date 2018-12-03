import java.util.Arrays;
import java.util.Date;


/**
 * Created by YuChen on 2018/2/28 0028
 */
public class Test {

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		Integer[] array = {1, 2, 3, 6, 8, 10};
		Integer number = Arrays.asList(array).stream().max((e1, e2) -> e1 - e2).get();
		System.out.println(number);

	}
}
