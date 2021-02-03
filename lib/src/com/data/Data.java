package com.data;

import com.struct.ListNode;

public class Data {

    public static final ListNode generateList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        return head;
    }
}
