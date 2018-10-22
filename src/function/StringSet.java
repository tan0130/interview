package function;

import java.util.HashMap;
import java.util.Scanner;

/**
 * create by 1311230692@qq.com on 2018/10/22 16:51
 * 题目：输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述：每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述：每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入样例：abcqweracb
 * 输出样例：abcqwer
 *
 * 思路：去除输入字符串中重复的字符，最后输出剩下的字符串。使用HashMap来处理这个问题,保存不存在的字符。
 **/
public class StringSet {

    /**
     * 主函数
     * */
    public static void main(String[] args) {
        System.out.println("输入字符串：");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("包含字符集合为：" + stringSet(str));
    }

    /**
     * 求字符串包含集合
     * */
    private static StringBuilder stringSet(String s) {
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Integer, Character> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsValue(s.charAt(i))) {
                j++;
                hm.put(j, s.charAt(i));
            }
        }

        for (int n: hm.keySet()) {
            stringBuilder.append(hm.get(n));
        }
        return stringBuilder;
    }

}
