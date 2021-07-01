package something.inputstream;

import java.io.*;

/**
 * @author chenyu
 * @date 2021-01-21
 */
public class InputStreamTest {

  public static void main(String[] args) {
    // 获取系统的分隔符
    System.out.println(File.separator);

    /** 读取文件内容 */
    InputStream is = new InputStreamTest().getClass().getResourceAsStream("test.text");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
    String readStr = "";
    String str = "";
    try {
      // 这里的判断
      while ((str = bufferedReader.readLine()) != null) {
        readStr += str;
      }
      System.out.println(readStr);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // 获取当前工程所在的绝对路径
    String path = new File("").getAbsoluteFile().getParentFile().toString();
    System.out.println(path);
  }
}
