package effectivejava.firchapter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by YuChen on 2017/9/1 0001
 */
public class Test {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("");
			connection = DriverManager.getConnection("");

		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
}
