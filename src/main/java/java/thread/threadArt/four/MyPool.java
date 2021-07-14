package java.thread.threadArt.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by YuChen on 2018/1/9 0009
 *
 * <p>线程池实例
 */
public class MyPool<Job extends Runnable> {

  private static final int MAX_WORKER_NUMBERS = 10; // 最大

  private static final int DEFAULT_WORKER_NUMBERS = 5; // 默认

  private static final int MIN_WORKER_NUMBERS = 1; // 最小

  private final LinkedList<Job> jobs = new LinkedList<Job>();

  private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

  private int workerNum = DEFAULT_WORKER_NUMBERS;

  private AtomicLong threadId = new AtomicLong();

  public static void main(String[] args) {
    System.out.println("1'");
    MyPool pool = new MyPool(10);
  }

  public MyPool() {
    initWorkers(DEFAULT_WORKER_NUMBERS);
  }

  public MyPool(int workerNum) {
    this.workerNum =
        workerNum > MIN_WORKER_NUMBERS && workerNum < MAX_WORKER_NUMBERS
            ? workerNum
            : DEFAULT_WORKER_NUMBERS;
    initWorkers(this.workerNum);
  }

  private void initWorkers(int workerNum) {
    for (int i = 0; i < workerNum; i++) {
      Worker worker = new Worker();
      workers.add(worker);
      Thread thread = new Thread(worker, "Thread - Worker - " + threadId.incrementAndGet());
      thread.start();
    }
  }

  public int getJobSize() {
    return jobs.size();
  }

  public void execute(Job job) {
    if (job != null) {
      synchronized (jobs) {
        jobs.addLast(job);
        job.notify();
      }
    }
  }

  public void addWWorkers(int num) {
    synchronized (jobs) {
      if (num + this.workerNum > MAX_WORKER_NUMBERS) {
        num = MAX_WORKER_NUMBERS - this.workerNum;
      }
      initWorkers(num);
    }
  }

  public void removeWorker(int num) {
    if (num > this.workerNum) throw new IllegalArgumentException("beyond workerNum");
    int count = 0;
    while (count < num) {
      Worker worker = workers.get(num);
      if (workers.remove(worker)) {
        worker.shutdown();
        count++;
      }
    }
    this.workerNum -= count;
  }

  public void shutdown() {
    for (Worker worker : workers) worker.shutdown();
  }

  private class Worker implements Runnable {

    private volatile boolean running = true;

    @Override
    public void run() {
      while (running) {
        Job job = null;
        synchronized (jobs) {
          while (jobs.isEmpty()) {
            try {
              jobs.wait();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              return;
            }
          }
          job = jobs.removeFirst();
        }

        if (job != null) {
          job.run();
        }
      }
    }

    private void shutdown() {
      running = false;
    }
  }
}
