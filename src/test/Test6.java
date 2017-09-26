package test;

import java.lang.reflect.Proxy;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Created by YuChen on 2017/9/22 0022
 */
public class Test6 {
	public static void main(String[] args) {
		Integer i = null;
		requireNonNull(i,"不能为null");
	}

	public void change() {
		Integer i = null;
		requireNonNull(i, "不能为空");
	}
}
