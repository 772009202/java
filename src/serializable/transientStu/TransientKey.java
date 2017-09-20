package serializable.transientStu;

import java.io.*;

/**
 * Created by YuChen on 2017/9/20 0020
 * transient此关键字的使用
 */
public class TransientKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient int data; // Stores session data

	//Session activation time (creation, deserialization)
	private transient long activationTime;

	public TransientKey(int data) {
		this.data = data;
		this.activationTime = System.currentTimeMillis();
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeInt(data);
		System.out.println("session serialized");
	}

	/**
	 * 注意读的时候必须按顺序读  data = ois.readInt();
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois) throws IOException,
			ClassNotFoundException {
		ois.defaultReadObject();
		data = ois.readInt();
		activationTime = System.currentTimeMillis();
		System.out.println("session deserialized");
	}

	public int getData() {
		return data;
	}

	public long getActivationTime() {
		return activationTime;
	}
}
