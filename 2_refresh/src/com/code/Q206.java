package com.code;

import com.data.Data;
import com.struct.ListNode;

/**
 * 反转链表
 */
public class Q206 {

    public static void main(String[] args) {
        ListNode list = Data.generateList();
        printList(list);
        list = reverseList(list);
        printList(list);
    }

    private static void printList(ListNode head) {
        if (head == null) return;
        StringBuilder sb = new StringBuilder();
        ListNode cursor = head;
        while (cursor != null) {
            sb.append(String.format("%d->", cursor.value));
            cursor = cursor.next;
        }
        System.out.println("\n" + sb);
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
