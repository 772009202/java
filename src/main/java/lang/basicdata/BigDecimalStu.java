package lang.basicdata;

import java.math.BigDecimal;

/**
 * Created by YuChen on 2018/2/27 0027
 *
 * 其他类型怎么安全转换为BigDecimal
 */
public class BigDecimalStu {

	public BigDecimal getBigDecimal(Object obj) {
		if (null == obj)
			return new BigDecimal(0);
		else if (obj instanceof BigDecimal)
			return (BigDecimal) obj;
		else
			{
				String str = obj.toString().trim();
				return "".equals(str) ? new BigDecimal(0) :
											new BigDecimal(Double.parseDouble(str));
			}
	}
}
