package algorithm;

import java.util.Arrays;

/**
 * 为统计一个文件中所有和为0的三整数元组的数量（假设整数不会溢出）
 *
 * Created by DBC-PC on 2018/9/30
 */
public class ThreeSum {

    //第一种算法
    public static int count0(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


   /* //第二种算法
    public static int count1(int[] a) {
        int n = a.length;
        int count = 0;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            if(rank(-a[i],a)>i){
                count++;
            }
        }
        return count;
    }*/

    //第二种算法
    public static int count1(int[] a) {
        int n = a.length;
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
                    count++;
                }
            }

        }
        return count;
    }
}
