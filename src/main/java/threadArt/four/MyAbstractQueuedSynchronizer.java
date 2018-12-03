package threadArt.four;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by YuChen on 2018/1/10 0010
 * 同步器的实现   自定义锁组件
 */
public class MyAbstractQueuedSynchronizer implements Lock{

	private static class Sync extends  AbstractQueuedSynchronizer {

		//判断是否占用状态
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		//状态为0的时候获取锁
		public boolean tryAcquire(int acquires) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		//释放锁将状态设置为0
		protected boolean tryRelease(int releases) {
			if (getState() == 0)
				throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		//返回Condition 每个Condition包含一个Condition队列
		Condition newCondition() {
			return new ConditionObject();
		}
	}

	private final Sync sync = new Sync();
	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}
}
