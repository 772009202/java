package reflex.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by YuChen on 2017/9/20 0020
 */
public class ClassLoaderStu {

	public static void main(String[] args) {
		//匿名内部类实现自定义类加载器
		ClassLoader myClassLoader = new ClassLoader(){
			protected Class<?> findClass(String name)throws ClassNotFoundException{
				//获取类文件名
				String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
				InputStream in = getClass().getResourceAsStream(filename);
				if(in == null){
					throw new RuntimeException("Could not found class file:" + filename);
				}
				byte[] b = new byte[0];
				try {
					b = new byte[in.available()];
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				return defineClass(name, b, 0, b.length);
			}
		};

		Object obj = null;
		try {
			obj = myClassLoader.loadClass("reflex.classloader.ClassLoaderStu").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(obj instanceof ClassLoaderStu);
	}
}

