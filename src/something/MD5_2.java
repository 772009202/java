package something;


import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by YuChen on 2017/9/28 0028
 * MD5加密实现
 */
public class MD5_2 {

	public static String MD5(String data) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		sb.append(new Random().nextInt(100));//简单加盐
		return sb.toString().toUpperCase();
	}

}
