package thread.thir;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by YuChen on 2017/10/12 0012
 */
public class Liu {

	public static void main(String[] args) throws InterruptedException, IOException {
		Write write = new Write();
		Read read = new Read();

		PipedInputStream inputStream = new PipedInputStream();
		PipedOutputStream outputStream = new PipedOutputStream();
		outputStream.connect(inputStream);
		Thread1 thread1 = new Thread1(write, outputStream);
		Thread2 thread2 = new Thread2(read, inputStream);
		thread1.start();
		Thread.sleep(2000);
		thread2.start();
	}

	static class Thread1 extends Thread{
		private Write write;
		private PipedOutputStream outputStream;
		Thread1 (Write write, PipedOutputStream outputStream) {
			this.write = write;
			this.outputStream = outputStream;
		}

		@Override
		public void run() {
			super.run();
			try {
				write.write(outputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static class Thread2 extends Thread {
		private Read read;
		private PipedInputStream inputStream;
		Thread2 (Read read, PipedInputStream inputStream) {
			this.read = read;
			this.inputStream = inputStream;
		}

		@Override
		public void run() {
			super.run();
			try {
				read.read(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	static class Write {

		void write (PipedOutputStream outputStream) throws IOException {
			System.out.println("------ 开始写出");
			for (int i=0; i<10; i++) {
				String str = "" + i;
				outputStream.write(str.getBytes());
				System.out.println("------一次写出");
			}
			System.out.println("------ 写出完毕");
			outputStream.close();
		}
	}

	static class Read {

		void read (PipedInputStream inputStream) throws IOException {
			byte[] bytes = new byte[20];
			int readLength = inputStream.read(bytes);
			System.out.println("------ 开始写入");
			while (readLength != -1) {
				String newDate = new String(bytes, 0, readLength);
				readLength = inputStream.read(bytes);
				System.out.println("------ 一次写入" + newDate);
			}
			System.out.println("------写入完毕");
			inputStream.close();
		}
	}
}
