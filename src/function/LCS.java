package function;

import java.util.Scanner;

/**
 * create by 1311230692@qq.com on 2018/10/22 16:24
 * 题目：删除部分字符使其变成回文串问题---最长公共子序列（LCS）
 *
 * 区别：
 *  最长公共子串：连续
 *  最长公共子序列：不必连续
 *
 * 分析：反序这个字符串，求新串和原串的最大子序列，需要删除字母个数，即为原字符串的长度减去最长公共子序列
 *
 * 求最长公共子序列思路：
 * 假设s1字符串的下标为n1,s2字符串的下标为n2,最长公共子序列的长度为L；分两种情况：
 * 1、假设s1(n1) == s2(n2),那么此时最长公共子序列的长度L(n1+1,n2+1)=L(n1,n2)+1,
 * 2、如果s1(n1) != s2(n2)，此时要么舍弃s1的n1字符，要么舍弃s2的n2字符，这样就从L(n1,n2+1)、L(n1+1,n2)中挑选更长的子序列为最长公共子序列
 **/
public class LCS {
    /**
     * 主函数
     * */
    public static void main(String[] args) {
       System.out.println("输入字符串：");
       Scanner input = new Scanner(System.in);
       String s = input.nextLine();
       System.out.println("需要删除：" + getCount(s) + "个字符串");
//       System.out.println("回文串为：" + );

    }

    /**
     * 获取应删除的长度
     * */
    private static int getCount(String s) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s).reverse();
        return s.length() - lcs(s1, s2);
    }

    /**
     * 求最长公共子序列（LCS）
     * */
    private static int lcs(StringBuilder s1, StringBuilder s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] mutrix = new int[n1 + 1][n2 + 2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    mutrix[i + 1][j + 1] = mutrix[i][j] + 1;
                } else {
                    mutrix[i + 1][j + 1] = Math.max(mutrix[i][j + 1], mutrix[i + 1][j]);
                }
            }
        }
        return mutrix[n1][n2];
    }

}
