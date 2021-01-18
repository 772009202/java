package reflect;

/**
 * 通过反射创建对象
 *
 * @author chenyu
 * @date 2021-01-15
 */
public class Demo1 {

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    //
    Class<Demo1> clazz = Demo1.class;
    Demo1 newObject = clazz.newInstance();
  }
}
