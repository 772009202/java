package something.generic;

/**
 * Created by YuChen on 2018/4/28 0028
 *
 * 泛型上限
 */
public class Demo4 {

	public static class IntegerPair<T extends Integer & Runnable> { //有继承是类的要放在第一个

		private T first;

		public T getFirst() {
			return first;
		}

		public void setFirst(T first) {
			this.first = first;
		}

		public void method(T first) { //泛型还能点出通用算法
			first.intValue();
		}

		public static <T extends Comparable<T>> int method2(T[] list) {
			return 0;
		}

		public static void main(String[] args) {
		 	   A[] array = {new A(), new A()};
		 	   System.out.println(method2(array));
		}
	}

	public static class A implements Comparable<A>{
		@Override
		public int compareTo(A o) {
			return 0;
		}

//		@Override
//		public int compareTo(Object o) {
//			return 0;
//		}

	}
}
