package leetcode;

/**
 * created by dbx on 2019/1/15
 */
public class Main {


    public static void main(String[] args) {

        int result = countPrimes3(1500000);
        System.out.println(result);
    }


    public static int countPrimes(int n) {
        int number = 0; //注意两个循环的起始值均为2，都为2时，不进入第二个循环，即默认2为质数
        int i = 2;
        while (i < n) {
            int j = 2;
            boolean flg = false;
            while (j < i) {
                if (i % j == 0) {
                    flg = true;//说明是素数
                    break;
                }
                j++;
            }
            if (!flg) {
                number++;
            }

            i++;
        }
        return number;

    }

    public static int countPrimes2(int n) {
        int number = 0; //注意两个循环的起始值均为2，都为2时，不进入第二个循环，即默认2为质数
        int i = 2;
        while (i < n) {
            int j = 2;
            boolean flg = false;
            while (j <= Math.sqrt(i)) {//优化点：可以不必从2~m-1，只需遍历2 ~ √m.因为如果m能被2 ~ m-1之间任一整数整除，
                // 其二个因子必定有一个小于或等于√m，另一个大于或等于√m。
                if (i % j == 0) {
                    flg = true;//说明是素数
                    break;
                }
                j++;
            }
            if (!flg) {
                number++;
            }

            i++;
        }
        return number;

    }

    /**
     * 埃拉托斯特尼筛法
     *
     * @param n
     * @return
     */
    public static int countPrimes3(int n) {
        int aa[] = new int[101];
        aa[2] = 0;
        int k = 2, tt = 0;
        while (tt < 101) {
            for (int i = 1; i < aa.length; i++) //将不是素数的数筛出
                if (i % k == 0 && i != k) aa[i] = 1;

            for (int i = 1; i < aa.length; i++) //将筛选后的第一个数当做新的筛子
                if (i > k && aa[i] == 0) {
                    k = i;
                    break;
                }
            tt++;
        }

        for (int i = 1; i < aa.length; i++)
            if (aa[i] == 0) System.out.printf("%d ", i);

        return 0;
    }


}
