package something.generic;

/**
 * Created by YuChen on 2017/9/25 0025
 *
 * 1.编译期 2.数据的校验 3.反射可跳过
 */
public class GenericDemo1<T> {

	private T object;

	protected GenericDemo1(T object) {
		this.object = object;
	}

	public T getObject() {  //泛型这里自带返回值类型（自动转型）
		return object;
	}

	public static void main(String[] args) {
		GenericDemo1<Integer> num = new GenericDemo1<Integer>(100);
		Integer i = num.getObject();
	}
}
