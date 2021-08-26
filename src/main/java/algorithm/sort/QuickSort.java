package algorithm.sort;

/**
 * @author chenyu
 * @date 2021-07-14
 */
public class QuickSort {

  public static void main(String[] args) {
    //
    int[] arr = {10, 2, 5, 3, 6, 8, 17, 52, 74, 1, 9, 2};
    quick(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "、");
    }
  }

  public static void quick(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    // 我们以左为基准线
    int point = arr[left];
    int r = right;
    int l = left;
    while (l < r) {
      // 右边寻找第一个小于基准的数
      while (arr[r] > point && r > l) {
        r--;
      }

      // 寻找左边第一个大于基准的数
      while (point >= arr[l] && l < r) {
        l++;
      }

      if (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
      }
    }
    arr[left] = arr[l];
    arr[l] = point;

    quick(arr, left, l - 1);
    quick(arr, l + 1, right);
  }
}
