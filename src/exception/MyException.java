package exception;

import java.io.Serializable;

/**
 * Created by YuChen on 2017/9/26 0026
 */
public class MyException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}

}
