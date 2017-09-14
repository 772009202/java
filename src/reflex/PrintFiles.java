package reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by YuChen on 2017/8/25 0025
 */
public class PrintFiles {

	public static void main(String[] args) {
		JavaBean bean = new JavaBean();
		bean.setB("10");
		bean.setF("11");

		Class<? extends JavaBean> aClass = bean.getClass();
		Field[] fields = aClass.getDeclaredFields();

		String methodName;
		String toUpper;
		String fieldName;
		Method method;

		//遍历过去类属性 拼接出对象的get方法 通过get方法遍历获取对象的和属性
		for (Field e: fields) {
			fieldName = e.getName();
			toUpper = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
			methodName = "get" + toUpper;
			try {
				//获取类的特定方法需要传入的参数
				method = aClass.getMethod("methodName");
				System.out.println(method.invoke(bean));
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
		}
	}
}
