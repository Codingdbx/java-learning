package algorithm;


/**
 * 二分法算法
 * Created by DBC-PC on 2018/9/1
 *
 */

public class BinarySearch {

    public static int rank(int key,int[] a){

        int lo=0;//数组的第一个元素
        int hi=a.length-1;//数组的最后一个元素
        while (lo<=hi){
            int mid=lo + (hi-lo)/2;//二分点
            if(key<a[mid]) {
                hi=mid-1;
            }else if(key>a[mid]){
                lo=mid+1;
            }else {
                return mid;//返回查找数组的下标
            }
        }
        return -1;//没有查到的话返回-1
    }


}
