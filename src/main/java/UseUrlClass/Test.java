package UseUrlClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YuChen on 2017/10/11 0011
 *
 * 这个流程我得琢磨
 */
public class Test {

	static final int messageNum = 100;//定义常量 消息长度
	static CountDownLatch count = new CountDownLatch(10);//指定10长度的计数器
	static AtomicInteger atomicInteger = new AtomicInteger(messageNum);//原子数递增变量
	static List<String> msgList = new ArrayList<String>(messageNum);//消息长度
	static String message = null;
	public static void main(String[] args) {
		int initArray = 0;//初始化消息列表长度
		while(initArray < messageNum){
			initArray ++ ;
			msgList.add("");
		}
		Thread t1;
		//多线程启动实例
		for(int i = 0 ; i < 10 ; i ++){
			t1 = new MyThread("t" + i);
			t1.start();
		}
		try {
			count.await();//计数器阻塞主线程继续执行 直到计数器减到0 主线程继续执行
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("---------");
		System.out.println(msgList);

	}
	static class MyThread extends Thread{
		public MyThread(String name) {
			this.setName(name);
		}
		@Override
		public void run() {
			count.countDown();//计数器递减 每一个线程进入就递减一个单位
			for(int i = 0 ; i < 10 ; i ++){
				atomicInteger.compareAndSet(messageNum, 0);//当原子数增长到指定数值是，恢复为初始值
				int curIndex = atomicInteger.incrementAndGet();
				message = Thread.currentThread().getName() + ":" + curIndex;
				setList(message,curIndex);
				System.out.println(message);

			}
		}
	}

	public static void setList(String message, int curIndex){
		msgList.set(curIndex - 1, message);
	}
}
