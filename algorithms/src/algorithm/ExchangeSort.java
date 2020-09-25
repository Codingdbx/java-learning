package algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>Description: 交换排序-冒泡排序</p>
 *
 * @author dbx
 * @date 2020/9/21 16:48
 * @since JDK1.8
 */
public class ExchangeSort {

    // 其外层循环执行 N - 1次。内层循环最多的时候执行N次，最少的时候执行1次
    // 平均执行 (N+1)/2次，其复杂度为O(N^2)
    public static void ExchangeSort(int[] arrs) {
        int tmp;
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    tmp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = tmp;
                }
            }
            System.out.println(i + ":" + Arrays.toString(arrs));
        }
    }

    // 按照改进的算法，对于一个已经有序的数组，算法完成第一次外层循环后就会返回
    // 实际上只发生了 N - 1次比较，所以最好的情况下，该算法复杂度是O(N)
    public static void ExchangeSortPlus(int[] arrs) {
        int tmp;
        for (int i = 1; i < arrs.length; i++) {
            boolean flg = false;
            for (int j = 0; j < arrs.length - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    tmp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = tmp;
                    flg = true;
                }
            }
            // 如果上一次扫描没有发生交换，则说明数组已经全部有序，退出循环
            if (!flg) {
                break;
            }
            System.out.println(i + ":" + Arrays.toString(arrs));
        }
    }

    public static void main(String[] args) {


    }


}
