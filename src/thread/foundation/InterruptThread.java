package thread.foundation;

import exception.MyException;

/**
 * Created by YuChen on 2017/9/30 0030
 * 1.interrupted(静态)判断运行此处的线程是不是被打断
 * 2.isInterrupted(非静态) 判断线程对象是否被打断
 */

/*
* 逻辑上终止线程:生产者根据消费者中断提前结束方法(例如break) 消费者主动打断,然而感觉并不好
* */
public class InterruptThread {

	public static void main(String[] args) throws InterruptedException {

	 	Thread.currentThread().interrupt();
	 	System.out.println(Thread.interrupted());
	 	System.out.println(Thread.interrupted()); //第二次最后 变false 清除状态的功能

		Thread threadDemo = new Thread(new ThreadDemo());
		threadDemo.start();
		threadDemo.interrupt();
		System.out.println("----" + threadDemo.isInterrupted());

	}

	/**
	 * 暴力的退出，不会执行下面的语句
	 */
	class A extends Thread{
		@Override
		public void run() {
			if(this.interrupted()) throw new MyException("----线程退出");
		}
	}
}


