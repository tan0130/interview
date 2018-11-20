package function;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * create by 1311230692@qq.com on 2018/11/20 8:51
 * 两个大整数相加,位数超过长整型,只能用 String 存储
 **/
public class TwoSum {
    public static void main(String[] args) {
//        System.out.println("两数和为：" + getResult("5567891236", "456789123"));
        System.out.println("两数和为：" + getTwoSum("5567891236", "456789123"));
    }

    /**
     * 求和基于字符数组
     * 可以使用类似小学做数学题，竖列按位相加，将整数每个位置的数字放入字符数组中，然后再相加
     * @param bigNumA 较大整数A
     * @param bigNumB 较大整数B
     * 时间：650ms
     * */
    private static String getResult(String bigNumA, String bigNumB) {
        char[] charA = new StringBuilder(bigNumA).reverse().toString().toCharArray();
        char[] charB = new StringBuilder(bigNumB).reverse().toString().toCharArray();
//        int maxLength = charA.length > charB.length ? charA.length:charB.length;
        int maxLength = Math.max(charA.length, charB.length);
        int[] result = new int[maxLength + 1];
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            if (i < charA.length) {
                temp += charA[i] - '0';
            }
            if (i < charB.length) {
                temp += charB[i] - '0';
            }
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }
            flag = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }


    /**
     * 使用 BigInteger 类、BigDecimal 类
     * */
    private static String getTwoSum(String s1, String s2) {
//        return new BigInteger(s1).add(new BigInteger(s2)).toString();
        return new BigDecimal(s1).add(new BigDecimal(s2)).toString();
    }
}
