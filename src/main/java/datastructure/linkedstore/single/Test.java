package datastructure.linkedstore.single;

/**
 * Created by YuChen on 2018/3/27 0027
 */
public class Test {

	public static void main(String[] args) {
		ListSLinked<String> list = new ListSLinked<String>();
		list.add("1");
		list.add("2");
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.indexOf("1"));
	}

}
