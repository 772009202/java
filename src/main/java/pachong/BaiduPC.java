package pachong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by YuChen on 2017/10/9 0009
 * 百度爬虫
 */
public class BaiduPC {
	public static void main(String[] args) {
		String urlStr = "http://www.baidu.com";
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sb.toString());
	}
}
