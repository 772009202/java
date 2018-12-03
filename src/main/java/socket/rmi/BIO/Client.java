package socket.rmi.BIO;

import java.io.*;
import java.net.Socket;

/**
 * Created by YuChen on 2017/12/15 0015
 */
public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		ObjectOutputStream os = null;
		ObjectInputStream is = null;

		try {
			socket = new Socket("127.0.0.1", 6666);
			os = new ObjectOutputStream(socket.getOutputStream());

			Stu stu =  new Stu();
			os.writeObject(stu);
			os.flush();
			System.out.println("传完数据");

			is = new ObjectInputStream(new BufferedInputStream(
					socket.getInputStream()));
			Stu stu2 = (Stu)is.readObject();
			System.out.println("-----访问结束");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
