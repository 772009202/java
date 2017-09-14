package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * 通过反射拼接sql
 * Created by YuChen on 2017/8/30 0030
 */
public class Test {

	public static void main(String[] args) {
		QyBase qyBase = new QyBase();
		qyBase.setAcccreditusetime("1");
		qyBase.setAgrlevel("2");
		try {
			insertQyBase(qyBase);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	public static void insertQyBase(QyBase qyBase) throws Exception{

		StringBuffer dbFieldName = new StringBuffer("");
		StringBuffer dbFieldValue = new StringBuffer("");
		System.out.println("2");
		//遍历企业基础信息对象域，不为空的拼接到sql插入到数据库
		Class<? extends QyBase> aClass = qyBase.getClass();
		Field[] fields = aClass.getDeclaredFields();

		for (Field e: fields) {

			String fieldsName = e.getName();
			String type = e.getGenericType().toString();
			String fieldsValue = "";
			String methodName = "get" + fieldsName.substring(0,1).toUpperCase() + fieldsName.substring(1);
			Method method = aClass.getMethod(methodName);

			if (type.equals("class java.lang.String")) {
				fieldsValue = (String) method.invoke(qyBase);
			}
			if (type.equals("class java.math.BigDecimal")) {
				if (null != (BigDecimal) method.invoke(qyBase))
					fieldsValue = ((BigDecimal) method.invoke(qyBase)).toString();
			}

			System.out.println(fieldsName);
			System.out.println(fieldsValue);
			if (fieldsValue == null || "".equals(fieldsValue)) continue;
			dbFieldName.append(fieldsName).append(",");
			dbFieldValue.append(fieldsValue).append(",");
		}

		dbFieldName = dbFieldName.deleteCharAt(dbFieldName.length()-1);
		dbFieldValue = dbFieldValue.deleteCharAt(dbFieldValue.length()-1);
		String sql = "insert into " + "tableName" + "(" + dbFieldName.toString() + ")" +
				" values(" + dbFieldValue.toString() + ")";
		System.out.println(sql);
	}
}
