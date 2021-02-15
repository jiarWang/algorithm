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
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1555 👎 0
public class Q22 {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        _gen(0, 0, n, result, new StringBuilder());
        return result;
    }

    /**
     * 动态规划，剪枝
     *
     * @param left
     * @param right
     * @param n
     * @param result
     * @param s
     */
    private static void _gen(int left, int right, int n, List<String> result, StringBuilder s) {
        if (left == right && left == n) {
            result.add(s.toString());
        }
        if (left < n) {
            _gen(left + 1, right, n, result, s.append("("));
            s.deleteCharAt(s.length() - 1);
        }
        if (left > right && right < n) {
            _gen(left, right + 1, n, result, s.append(")"));
            s.deleteCharAt(s.length() - 1);
        }
    }
}
