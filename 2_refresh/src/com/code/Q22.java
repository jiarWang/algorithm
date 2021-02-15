package com.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 示例 1：
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
public class Q22 {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        _gen(n, 0, 0, result, new StringBuilder());
        return result;
    }

    private static void _gen(int n, int left, int right, List<String> result, StringBuilder str) {
        if (left == right && left == n) {
            result.add(str.toString());
        }
        if (left < n) {
            _gen(n, left + 1, right, result, str.append("("));
            str.deleteCharAt(str.lastIndexOf("("));
        }
        if (left > right && right < n) {
            _gen(n, left, right + 1, result, str.append(")"));
            str.deleteCharAt(str.lastIndexOf(")"));
        }
    }
}
