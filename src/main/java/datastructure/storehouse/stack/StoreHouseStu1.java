package datastructure.storehouse.stack;

/**
 * Created by YuChen on 2018/3/7 0007
 *
 * 2018转成8进制的表示
 */
public class StoreHouseStu1 {

	public static void main(String[] args) {
	 	int num = 2018;
	 	StoreHouse<String> stack = new StoreHouse<String>();

	 	while(num > 0)
		{
			stack.push(num%8 + "");
			num = num/8;
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop());
	}
}
