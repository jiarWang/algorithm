package com.code;

import com.struct.ListNode;

/**
 * 反转列表
 */
public class Q206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preNode = null;
        ListNode current = head;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = preNode;
            preNode = current;
            current = tmp;
        }
        return preNode;
    }
}
