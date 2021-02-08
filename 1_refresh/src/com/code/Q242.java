package com.code;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 有效的字母异位词
 */
public class Q242 {

    public static boolean validAnagram(String target, String src) {
        if (target == src) return true;
        if (target == null || src == null) return false;
        int[] abc = new int['z' - 'a' + 1];
        Arrays.fill(abc, 0);
        for (char c : target.toCharArray()) {
            abc[c - 'a'] += 1;
        }
        for (char c : src.toCharArray()) {
            abc[c - 'a'] -= 1;
        }
        for (int i : abc) {
            if (i != 0) return false;
        }
        return true;
    }
}
