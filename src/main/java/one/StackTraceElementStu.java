package one;

import exception.MyException;

/**
 * Created by YuChen on 2017/9/27 0027
 * 1、Thread.currentThread().getStackTrace()
 * 2、new Throwable().getStackTrace()
 * StackTrace(堆栈轨迹)存放的就是方法调用栈的信息
 */
public class StackTraceElementStu {
	public static void main(String[] args)
	{
		new StackTraceElementStu().methodA();
	}

	private void methodA(){
		System.out.println("------进入methodA----------");
		methodB();
	}

	/*------进入methodA----------
			------进入methodB----------
	StackTraceElement数组下标 i=0,fileName=Thread.java,className=java.lang.Thread,methodName=getStackTrace,lineNumber=1559
	StackTraceElement数组下标 i=1,fileName=StackTraceElementStu.java,className=one.StackTraceElementStu,methodName=methodB,lineNumber=30
	StackTraceElement数组下标 i=2,fileName=StackTraceElementStu.java,className=one.StackTraceElementStu,methodName=methodA,lineNumber=19
	StackTraceElement数组下标 i=3,fileName=StackTraceElementStu.java,className=one.StackTraceElementStu,methodName=main,lineNumber=14*/
	private void methodB(){
		System.out.println("------进入methodB----------");
		StackTraceElement elements[] = Thread.currentThread().getStackTrace();
		for (int i = 0; i < elements.length; i++) {
			StackTraceElement stackTraceElement=elements[i];
			String className=stackTraceElement.getClassName();
			String methodName=stackTraceElement.getMethodName();
			String fileName=stackTraceElement.getFileName();
			int lineNumber=stackTraceElement.getLineNumber();
			System.out.println("StackTraceElement数组下标 i="+i+",fileName="
					+fileName+",className="+className+",methodName="+methodName+",lineNumber="+lineNumber);
		}
	}

	public static void isOnMethod() {
		StackTraceElement[] StackTrace = Thread.currentThread().getStackTrace();
		boolean result = false;
		for (StackTraceElement stackTraceElement : StackTrace) {

			String className = stackTraceElement.getClassName();
			String methodName = stackTraceElement.getMethodName();
			System.out.println("className="+className+",methodName="+methodName+",line="+ stackTraceElement.getLineNumber());
			try {
				boolean assignableFromClass = Class.forName(className).isAssignableFrom(Activivty.class);
				if (assignableFromClass && "onresum".equals(methodName))
						result = true;
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}

		if (!result) throw new MyException("isOnMethod must in Activity.onresum");
		System.out.println("成功");
	}
}
class Activivty{

	public static void onresum() {
		StackTraceElementStu.isOnMethod();
	}

	public static void main(String[] args) {
		onresum();
	}
}