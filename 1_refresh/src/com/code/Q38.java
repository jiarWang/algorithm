package com.code;

/**
 * 外观数列
 */
public class Q38 {
    public static void main(String[] args) {

        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n == 0) return "";
        StringBuilder sb = new StringBuilder("1");
        for(int i = 0; i < n - 1; i ++){
            String preStr = sb.toString();
            int len = preStr.length();
            int count = 0;
            char c = 0;
            sb.delete(0, len);//复原
            for(int j = 0; j < len; j ++){
                if (c == preStr.charAt(j)){
                    count++;
                }else {
                    if (count != 0){
                        sb.append(count);
                        sb.append(c);
                    }
                    c = preStr.charAt(j);
                    count = 1;
                }
            }
            if (count != 0){
                sb.append(count);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
