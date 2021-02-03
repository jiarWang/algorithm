package com.code;

import com.data.Data;
import com.struct.ListNode;
import com.util.ListUtils;

/**
 * 反转链表
 */
public class Q206 {

    public static void main(String[] args) {
        ListNode list = Data.generateList();
        ListUtils.printList(list);
        list = reverseList(list);
        ListUtils.printList(list);
    }


    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
