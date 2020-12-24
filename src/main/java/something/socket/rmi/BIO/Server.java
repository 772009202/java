package something.socket.rmi.BIO;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by YuChen on 2017/12/15 0015
 */
public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(6666);

		while (true) {
			System.out.println("---------------堵塞中");
			Socket socket = serverSocket.accept();
			System.out.println("------------开始接受信息");
			invoke(socket);
		}
	}

	public static void invoke(final Socket socket) {

		new Thread( () -> {
			ObjectInputStream is = null;
			ObjectOutputStream os = null;
			try {
				is = new ObjectInputStream(new BufferedInputStream(
						socket.getInputStream()));
				os = new ObjectOutputStream(new BufferedOutputStream(
						socket.getOutputStream()));
				os = new ObjectOutputStream(socket.getOutputStream());
				Object obj = is.readObject();
				Stu stu = (Stu) obj;

				System.out.println(stu);

				os.writeObject(stu);
				os.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
