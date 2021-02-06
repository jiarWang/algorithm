package com.util;

import com.struct.ListNode;

public class ListUtils {
    public static void printList(ListNode head) {
        if (head == null) return;
        StringBuilder sb = new StringBuilder();
        ListNode cursor = head;
        while (cursor != null) {
            sb.append(String.format("%d->", cursor.value));
            cursor = cursor.next;
        }
        System.out.println("\n" + sb);
    }

    public static final ListNode generateList(int size) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 0; i < size - 1; i++) {
            current.next = new ListNode(i + 2);
            current = current.next;
        }
        return head;
    }
}
