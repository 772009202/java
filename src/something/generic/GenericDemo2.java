package something.generic;

/**
 * Created by YuChen on 2017/9/25 0025
 */
public class GenericDemo2 {

	public static class Obj<T>{
		private T obj;
		Obj(T obj) {
			this.obj = obj;
		}
		public T getObj() {
			return obj;
		}
	}

	/**
	 * 注意通配符的使用
	 * @param obj
	 */
	private static Number getDate(Obj<? extends Number> obj) {
		return obj.getObj();  //这里会
	}

	public static void main(String[] args) {
		Obj<Integer> o1 = new Obj<Integer>(100);
		Obj<Number> o2 = new Obj<Number>(200);
		Number n1 = getDate(o1);
		Number n2 = getDate(o2);
		n1.byteValue();
		n2.byteValue();

		byte a = 1;
	}
}
