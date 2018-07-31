package effectivejava.thichapter;

/**
 * TreeSet 和 HashSet比较的是compareTo 一样只存一个  而不是比较equals
 * Created by YuChen on 2017/9/12 0012
 */
public class ComparableTest implements Comparable<ComparableTest> {

	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public int compareTo(ComparableTest o) {
		return o.getI() - this.getI();
	}

}
