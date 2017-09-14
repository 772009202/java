package effectivejava.firchapter.staticmethod;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by YuChen on 2017/9/1 0001
 */
public class Services {

	private static final Map<String, Provider> providers =
			new ConcurrentHashMap<String, Provider>();
	private static final String DEFAULT_PROVIDER_NAME = "<def>";

	private Services() {}

	private Services(String ...ab) {}

	public static void registerDefaultProvider(Provider provider) {
		registerProvider(DEFAULT_PROVIDER_NAME, provider);
	}

	public static void registerProvider(String name, Provider provider) {
		providers.put(name, provider);
	}

	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) {
			throw new IllegalArgumentException("no private registered with name");
		}
		return p.newService();
	}

	public void a(){

	}
}

interface Service {
	void a(String str);
}

interface Provider {
	Service newService();
	Collections a();
}