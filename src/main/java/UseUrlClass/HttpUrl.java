package UseUrlClass;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by YuChen on 2017/9/7 0007
 */
public class HttpUrl {

	private static final String GET_URL = "http://112.4.27.9/mall-back/if_user/store_list?storeId=32";
	private static final String POST_URL = "http://112.4.27.9/mall-back/if_user/store_list";

	public static void main(String[] args) {
		httpURLConnection2();
	}

	/**
	 * GET请求
	 */
	public static void httpURLConnection() {
		try {
			URL url = new URL(GET_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();  //持续会话

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			StringBuilder sb = new StringBuilder();

			while((line = br.readLine()) != null) {
				sb.append(line);
			}

			br.close();
			con.disconnect();
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败");
		}
	}

	/**
	 * post的请求
	 */
	public static void httpURLConnection2() {
		try {

			URL url = new URL(POST_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setUseCaches(false);
			con.setInstanceFollowRedirects(true);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			DataOutputStream dataout = new DataOutputStream(con.getOutputStream());
			String parm = "storeId=" + URLEncoder.encode("32", "utf-8");
			dataout.writeBytes(parm);
			System.out.println(con.getResponseCode());

			dataout.flush();
			dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)

			BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			StringBuilder sb = new StringBuilder(); // 用来存储响应数据

			// 循环读取流,若不到结尾处
			while ((line = bf.readLine()) != null) {
				sb.append(bf.readLine());
			}
			bf.close();    // 重要且易忽略步骤 (关闭流,切记!)
			con.disconnect(); // 销毁连接
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
