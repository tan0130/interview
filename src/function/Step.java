package function;

import java.util.Scanner;

/**
 * create by 1311230692@qq.com on 2018/10/22 16:09
 * 上台阶：京东笔试编程题
 *
 * 题目描述：有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 *
 * 测试样例：
 *  台阶数：3
 *  方式：2
 *
 * 分析：测试样例，输入台阶数3，只有两种有效方式，也就是只能1,2或2,1，这样可以采用奇偶思想，两个1之间必须要有一个2。
 *
 * 思路1：采用递归方式（台阶数较多时会超时，不建议采用）
 * 思路2：采用动态规划方法
 **/
public class Step {

    /**
     * 主函数
     * */
    public static void main(String[] args) {
        System.out.print("台阶数：");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println("上楼方式有：" + method1(num) + "种");
    }

    /**
     * 思路1：采用递归方式
     * @param n 台阶数
     * */
    private static int method(int n) {
        if (n > 2) {
            return (method(n-1) + method(n - 2)) % 1000000007;
        } else {
            return 1;
        }
    }

    /**
     * 思路2：采用动态规划
     * @param n 台阶数
     * */
    private static int method1(int n) {
        int[] sum = new int[101];
        sum[0] = 0;
        sum[1] = 0;
        sum[2] = 1;
        sum[3] = 2;
        for (int i = 4; i <= n; i++) {
            sum[i] = (sum[i - 2] + sum[i - 1]) % 1000000007;
        }
        return sum[n];
    }
}
