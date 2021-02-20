package com.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Q22 {

    public static void main(String[] args) {
        Q22 a = new Q22();
        a.generateParenthesis(4);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        _gen(list, 0, 0, 3, new StringBuilder());

        for (String s : list) {
            System.out.println(s);
        }
        return list;
    }


    private void _gen(List<String> resultList,int left, int right, int n, StringBuilder stringBuilder){
        if (left == right && left ==n){
            resultList.add(stringBuilder.toString());
            return;
        }
        //添加左括号
        if (left < n){
            _gen(resultList, left + 1, right, n, stringBuilder.append("("));
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("("));
        }
        if (left > right && right < n){
            _gen(resultList, left, right + 1, n, stringBuilder.append(")"));
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(")"));
        }
    }
}
