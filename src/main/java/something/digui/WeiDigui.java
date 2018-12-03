package something.digui;

/**
 * Created by YuChen on 2018/3/21 0021
 */
public class WeiDigui {

	/**
	 * 普通递归
	 * @param num
	 * @return
	 */
	public static Long diGui(final long num) {
		if (num<=1)
			return num;
		else return diGui(num -1) * num;
	}

	/**
	 * 尾递归
	 * @param num
	 * @param count
	 * @return
	 */
	public static Long weiDiGui(final long num, final long count) {
		if (num<=1)
			return count;
		else return weiDiGui(num-1, num*count);
	}

	public static void main(String[] args) {
		System.out.println(diGui(20));
		System.out.println(weiDiGui(10, 1));
	}
}
