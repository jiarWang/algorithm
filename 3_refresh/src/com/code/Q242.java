package com.code;

import java.util.Arrays;
import java.util.Collections;

public class Q242 {

    public static void main(String[] args) {

    }
    public static boolean isAnagram(String s, String t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
