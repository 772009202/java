package datastructure.storehouse.dequeue;

/**
 * Created by YuChen on 2018/3/27 0027
 *
 * 队列接口
 */
public interface Queue {

	//大小
	public int getSize();

	//是否为空
	public boolean isEmpty();

	//obj入队
	public void enqueue(Object object);

	//首元素出队
	public Object dequeue();

	//取队首元素
	public Object peek();

}
