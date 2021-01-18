package map.mymap1_7;

/**
 * @author Administrator
 * @date 2020-02-21
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

  /** 初始容量 */
  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
  /** 加载银子 */
  static final float DEFAULT_LOAD_FACTOR = 0.75f;
  /** 最大容量 */
  static final int MAXIMUM_CAPACITY = 1 << 30;
  /** 实际加载因子 */
  final float loadFactor;
  /** 实际数据容量 */
  int size;
  /**
   * The next size value at which to resize (capacity * load factor). <br>
   * 阈值---到达这个值就开始扩容 12而不是16才扩容
   */
  int threshold;
  /** 底层数组为空 */
  transient Entry<K, V>[] table = null;

  public MyHashMap() {

    this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  /**
   * 初始化 加载因子合法性
   *
   * @param initialCapacity
   * @param loadFactor
   */
  public MyHashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
    }
    if (initialCapacity > MAXIMUM_CAPACITY) {
      initialCapacity = MAXIMUM_CAPACITY;
    }
    if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
      throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
    }
    this.loadFactor = loadFactor;
    threshold = initialCapacity;
    init();
    table = null;
  }

  /** 模板方法 后期由子类去实现 */
  void init() {}

  @Override
  public int size() {
    return 0;
  }

  @Override
  public V get(K k) {
    return null;
  }

  @Override
  public V put(K k, V v) {
    // 初始化一个实际的容量
    if (table == null) {
      inflateTable(threshold);
    }
    // 这边有个key=null 操作
    int hash = hash(k);
    int i = indexFor(hash, table.length);
    // 如果命中的标有值并且相等 覆盖
    for (Entry<K, V> indexEntry = table[i]; indexEntry != null; indexEntry = indexEntry.next) {
      if (hash == indexEntry.hash && k.equals(indexEntry.getKey())) {
        // 覆盖 并且返回旧值
        V oldValue = indexEntry.getValue();
        indexEntry.setValue(v);
        return oldValue;
      }
    }
    // 不覆盖
    addEntry(hash, k, v, i);
    return null;
  }

  void addEntry(int hash, K key, V value, int bucketIndex) {

    //    if ((size >= threshold) && (null != table[bucketIndex])) {
    //      resize(2 * table.length);
    //      hash = (null != key) ? hash(key) : 0;
    //      bucketIndex = indexFor(hash, table.length);
    //    }

    createEntry(hash, key, value, bucketIndex);
  }

  /**
   * @param hash hash值
   * @param key
   * @param value
   * @param bucketIndex 命中的下标索引
   */
  void createEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K, V> next = table[bucketIndex];
    table[bucketIndex] = new Entry<K, V>(hash, key, value, next);
    size++;
  }
  /**
   * 默认的数组初始化
   *
   * @param toSize
   */
  private void inflateTable(int toSize) {
    // Find a power of 2 >= toSize
    int capacity = roundUpToPowerOf2(toSize);
    // 计算初始容量 16-10亿 取最小值
    threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
    // 实际初始容量
    table = new Entry[capacity];
    //    initHashSeedAsNeeded(capacity);
  }

  /**
   * 计算出hash值
   *
   * @param k
   * @return
   */
  final int hash(Object k) {
    int h = 0;
    //    if (0 != h && k instanceof String) {
    //      return sun.misc.Hashing.stringHash32((String) k);
    //    }
    h ^= k.hashCode();
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
  }

  /**
   * 命中下标
   *
   * @param h
   * @param length
   * @return
   */
  static int indexFor(int h, int length) {
    return h & (length - 1);
  }

  private static int roundUpToPowerOf2(int number) {
    // assert number >= 0 : "number must be non-negative";
    return number >= MAXIMUM_CAPACITY
        ? MAXIMUM_CAPACITY
        : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
  }

  class Entry<K, V> implements MyMap.Entry<K, V> {

    private K k;
    private V v;
    public Entry<K, V> next;
    public int hash;

    public Entry(K k, V v, Entry<K, V> next) {
      this.k = k;
      this.v = v;
      this.next = next;
    }

    public Entry(int hash, K k, V v, Entry<K, V> next) {
      this.k = k;
      this.v = v;
      this.next = next;
      this.hash = hash;
    }

    public Entry(K k, V v) {
      this.k = k;
      this.v = v;
    }

    @Override
    public V setValue(V value) {
      this.v = value;
      return this.v;
    }

    @Override
    public V getValue() {
      return this.v;
    }

    @Override
    public K getKey() {
      return this.k;
    }
  }
}
