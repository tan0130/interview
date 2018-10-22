package function;

import java.util.Scanner;

/**
 * create by 1311230692@qq.com on 2018/10/22 17:02
 * 输入有序4个数字，组成无重复的三位数
 *
 * 输入例子：1，2，3，4
 * 输出结果：24个
 **/
public class Number {
    /**
     * 主函数
     * */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入四个数字：");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        int n4 = input.nextInt();
        System.out.println("共有：" + getNumber(n1, n2, n3, n4) + "个不重复的三位数");
    }

    /**
     * 获取组合数
     * */
    private static int getNumber(int n1, int n2, int n3, int n4) {
        int max = n1;
        int count = 0;
        if (n2 > max) {
            max = n2;
        }
        if (n3 > max) {
            max = n3;
        }
        if (n4 > max){
            max = n4;
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                for (int k = 0; k < max; k++) {
                    if (i != j && i != k && j != k) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}
