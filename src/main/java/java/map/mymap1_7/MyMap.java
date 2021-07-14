package java.map.mymap1_7;

/**
 * 自定义的map接口
 *
 * @author Administrator
 * @date 2020-02-21
 */
public interface MyMap<K, V> {

  int size();

  V get(K k);

  V put(K k, V v);

  interface Entry<K, V> {
    V setValue(V value);

    V getValue();

    K getKey();
  }
}
