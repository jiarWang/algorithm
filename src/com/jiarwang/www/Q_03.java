package com.jiarwang.www;

public class Q_03 {

    public static void main(String[] args) {
        System.out.println(replaceSpaces("Mr John Smith    ", 13));
    }

    public static String replaceSpaces(String S, int length) {
        int j = S.length() - 1;
        char[] chars = S.toCharArray();
        for(int i = length - 1; i >= 0; i--){
            if(chars[i] == ' '){
                chars[j --] = '0';
                chars[j --] = '2';
                chars[j --] = '%';
            }else{
                chars[j --] = chars[i];
            }
        }
        return String.valueOf(chars).substring(j + 1);
    }
}
