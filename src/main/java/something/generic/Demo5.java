package something.generic;

/**
 * Created by YuChen on 2018/4/28 0028
 *
 * 无界限的泛型 编译期擦拭的时候为object
 * 有界限的为分界
 */
public class Demo5 {

	public static class Pair<T> {

		private T first;

		public T getFirst() { return first; }

		public void setFirst(T newValue) { first = newValue; }
	}

}
