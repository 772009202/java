package algorithm.fenzhi;

/**
 * Created by YuChen on 2018/3/29 0029
 *
 * <p>分治法 在a[n]中找出最大和最小元素
 */
public class FenZhi {

  public Store getMaxAndMin(int[] array, int low, int high) {
    Store store = new Store();
    if (high - 2 < low) {
      if (high == low) store.x = store.y = array[low];
      else {
        store.x = array[low] > array[high] ? array[high] : array[low];
        store.y = array[low] > array[high] ? array[low] : array[high];
      }
    } else {
      int mid = (high + low) / 2;
      Store store1 = getMaxAndMin(array, low, mid);
      Store store2 = getMaxAndMin(array, mid + 1, high);
      store.x = store1.x > store2.x ? store2.x : store1.x;
      store.y = store1.y > store2.y ? store1.y : store2.y;
    }

    return store;
  }

  public static void main(String[] args) {
    FenZhi fenZhi = new FenZhi();
    int[] a = {1, 3, 34, 24, 2, 324, 89, 2344, 213};
    System.out.println(fenZhi.getMaxAndMin(a, 0, a.length - 1));
  }

  static class Store {
    public int x; // 最小
    public int y; // 最大

    @Override
    public String toString() {
      return "Store{" + "x=" + x + ", y=" + y + '}';
    }
  }
}
