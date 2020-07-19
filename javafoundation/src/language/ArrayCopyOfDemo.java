package language;

import java.util.Arrays;

/**
 * created by dbx on 2019/2/28
 */
public class ArrayCopyOfDemo {

    public static void main(String[] args) {

        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd'};

        char[] copyTo = Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));

        //填充copyTo数组中的每个元素都是'k'
        Arrays.fill(copyTo,'k');

        //排序
        Arrays.sort(copyTo);
        //多处理器系统上的大型数组的并行排序比顺序数组排序更快
        Arrays.parallelSort(copyTo);

        //比较
        Arrays.equals(copyTo, copyFrom);

        //二分查找
        Arrays.binarySearch(copyFrom, 'f');

    }
}
