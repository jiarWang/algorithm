package com.code;

import com.struct.ListNode;

/**
 * 判断列表是否有环
 *
 * 1、思路一：使用Set
 * 2、思路二：使用快慢指针
 */
public class Q141 {
    public static void main(String[] args) {

    }
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
