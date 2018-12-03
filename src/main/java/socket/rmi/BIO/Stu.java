package socket.rmi.BIO;

import java.io.Serializable;

/**
 * Created by YuChen on 2017/12/15 0015
 *
 */
public class Stu implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name = "zhangsan";

	private String card = "115566";

	private transient String id = "123"; //设置一个不被序列化的字段

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Stu{" +
				"name='" + name + '\'' +
				", card='" + card + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}
