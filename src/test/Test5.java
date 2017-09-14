package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 题目 ：  删除一个字符串中出现次数最少的字符
 * Created by YuChen on 2017/9/13 0013
 */
public class Test5 {

	 public static void main(String[] args) {
	 	String str = "abcc";
	 	int min = 1;
	 	int start = 0;
	 	List<Character> list = new LinkedList<Character>();
	 	Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i<str.length(); i++) {
			int count;
			Integer num = map.get(str.charAt(i));

			if (null != num) {
				map.put(str.charAt(i), num + 1);
				count = num +1;
			} else {
				map.put(str.charAt(i), 1);
				count = 1;
			}

			if (count <= min) min = count;
		}

		for (Character e: map.keySet()) {
			System.out.println(map.get(e));
			System.out.println(min);
			if (map.get(e) == min) list.add(e);
		}
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
			str.replace(list.get(i).toString(), "");
		}

		System.out.println(str);
	 }
}
