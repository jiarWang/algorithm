package com.code;

import com.struct.ListNode;

/**
 * 环形链表
 */
public class Q141 {
    public static void main(String[] args) {

    }

    private static boolean circleList(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (slow != null && fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
