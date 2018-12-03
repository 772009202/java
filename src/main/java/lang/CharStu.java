package lang;

/**
 * Created by YuChen on 2018/2/23 0023
 *
 * Unicode 是「字符集」：为每一个字符确定一个唯一的码位
 * UTF-8 是「编码规则」：将码位转换为字节顺序
 *
 * Ascii编码 是最早的字符集，一个字节（8位2进制）标志一个字符，后来不够用了
 * 			就产生扩展字符集127 - 255
 * 后来unicode编码集出来了，统一都是2个字节的码位
 * 		UTF-8是将2个字节的值分成4个区域，4个区域对应1-4位字节
 */
public class CharStu {

	public static void main(String[] args) {
		char a = '难';
//		char b = '很难';
	 	System.out.println(a);
	}
}
