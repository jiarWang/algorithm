package com.code;
//给定一个正整数 n ，输出外观数列的第 n 项。
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
//
// 你可以将其视作是由递归公式定义的数字字符串序列：
//
//
// countAndSay(1) = "1"
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
//
//
// 前五项如下：
//
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
public class Q38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        if (n == 0 || n == 1) return String.valueOf(n);
        int count = 0;
        char currentChar = 0;
        StringBuilder builder = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            int size = builder.length();
            String preStr = builder.toString();
            builder.delete(0, size);
            currentChar = 0;
            count = 0;
            for (int j = 0; j < size; j++) {
                if (preStr.charAt(j) == currentChar){
                    count ++;
                }else {
                    if (count > 0) {
                        builder.append(count);
                        builder.append(currentChar);
                    }
                    currentChar = preStr.charAt(j);
                    count = 1;
                }
            }
            builder.append(count);
            builder.append(currentChar);
        }
        return builder.toString();
    }
}
