package class01;

/**
 * <p>Description: </p>
 *
 * @author dbx
 * @date 2020/10/30 22:55
 * @since JDK1.8
 */
public class Code07_EvenTimesOddTimes {

    //一个数组中有一种数出现其数次，其他数都出现了偶数次，怎么找到并打印这种数
    //arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;

        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        System.out.println(eor);

    }


    //arr中，有两种数，出现了奇数次
    public static void printOddTimesNum2(int[] arr) {

        int eor = 0;

        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        //eor = a^b
        //eor != 0
        //eor 必然有一个数字是1
        int rightOne = eor & (~eor + 1);//提出最右侧的1


        int onlyOne = 0;// eor'
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0) {
                onlyOne ^= arr[i];
            }
        }

        System.out.println(onlyOne + ":" + (onlyOne^eor));

    }


    //找出二进制位数为1的个数
    public static int bit1count(int N) {

        int count = 0;

        while (N != 0) {
            int rightOne = N & (~N + 1);

            N ^= rightOne;

            count++;
        }

        return count;
    }



}
