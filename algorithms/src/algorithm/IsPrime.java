package algorithm;

/**
 * 判断一个数是否为质数
 * created by dbix on 2019/7/11
 */
public class IsPrime {

    //一个数除了1和本身之外，应该还有其他约数，就不是质数，称为素数
    //只需要判断 2 到 n-1 是否存在约数
    static int isPrime_1(int num) {

        int tmp = num - 1;
        for (int i = 2; i <= tmp; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    //一个数能进行因数分解，那么分解得到的两个数一个大于等于它的平方根，一个小于等于平方根
    static int isPrime_2(int num) {
        double tmp = Math.sqrt(num);
        for (int i = 2; i <= tmp; i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {

        System.out.println(IsPrime.isPrime_1(2));
        System.out.println(IsPrime.isPrime_1(7));
        System.out.println(IsPrime.isPrime_1(97));
        System.out.println(IsPrime.isPrime_1(100));

    }
}
