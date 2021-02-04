package com.data;

import com.struct.ListNode;

public class Data {

    public static final ListNode generateList() {
        return generateList(8);
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
