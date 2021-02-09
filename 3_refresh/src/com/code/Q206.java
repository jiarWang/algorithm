package com.code;

import com.struct.ListNode;

/**
 * 反转链表
 */
public class Q206 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head){
        if (head == null) return head;
        ListNode pre = null, current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
