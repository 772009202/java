package Collection.list.something;

import java.util.Iterator;

/**
 * Created by YuChen on 2018/1/12 0012
 *
 */
public class ToArray {

	public void toArray(Object[] objs, Iterator it) {
		int i = objs.length;
		while (it.hasNext()) {
			int cap = objs.length;
			if (cap == i) {
				//这里面就可以扩容
			}
			objs[i++] = it.next();
		}

	}

}
