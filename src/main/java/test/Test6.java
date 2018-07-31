package test;

import exception.MyException;

import java.lang.reflect.Proxy;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Created by YuChen on 2017/9/22 0022
 */
public class Test6 {
	public static void main(String[] args) {
		int i = 0;
		if(i == 0) throw new MyException("不能为0");
	}

	public void change() {
		Integer i = null;
		requireNonNull(i, "不能为空");
	}
}
