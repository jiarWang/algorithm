package com.code;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q242 {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String p, String q) {
        if (p == q) return true;
        if (p == null || q == null) return false;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char c : p.toCharArray()) {
            int i = c - 'a';
            count[i] += 1;
        }
        for (char c : q.toCharArray()) {
            int i = c - 'a';
            count[i] -= 1;
            if (count[i] < 0) return false;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
