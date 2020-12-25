package class01;

/**
 * <p>Description: 选择排序</p>
 *
 * @author dbx
 * @date 2020/10/29 12:33
 * @since JDK1.8
 */
public class Code01_SelectionSort {

    public static void selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        //0 ～ N-1
        //1 ～ N-1
        //2 ～ N-1
        for (int i = 0; i < arr.length - 1; i++) {

            //找到最小值在哪 i ～ N-1
            int minIndex = i;
            for (int j = 1; j < arr.length - 1; j++) {//i ～ N-1 找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
