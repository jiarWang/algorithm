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
}
