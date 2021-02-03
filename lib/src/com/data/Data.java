package com.data;

import com.struct.ListNode;

public class Data {

    public static final ListNode generateList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        return head;
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
