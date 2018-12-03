package exception;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by YuChen on 2017/9/26 0026
 */
public class MyException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	public MyException(String message) {
		super(message);
	}

}
