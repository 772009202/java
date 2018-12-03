package something.enumStu;

/**
 * Created by YuChen on 2017/9/28 0028
 */
public class Test {

	public static void main(String[] args) {
		chooseColor(Color.BLANK.getValue());
		chooseColor(Color.YELLOW.getValue());

	}

	public static void chooseColor(Color color) {
		switch (color) {
			case RED:
				System.out.println("红色");
				break;
			case BLANK:
				System.out.println("blank");
				break;
			default:
				System.out.println(color);
				break;
		}
	}

	public static void chooseColor(String str) {
		System.out.println(str);
	}
}
