package something.enumStu;

/**
 * Created by YuChen on 2017/9/28 0028
 * 枚举类
 * 1.枚举已经有默认继承类了 所以不能再继承了 但是可以实现接口
 */
public enum Color {

	RED,
	GREEN,
	BLANK,
	YELLOW("黄色", "yellow"); //有自定义方法 这边必须是分号

	private String key;
	private String value;

	Color() {
	}

	Color(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.key + this.value;
	}
}
