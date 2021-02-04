package com.code;

import com.code.util.Utils;
import com.data.Data;
import com.struct.ListNode;
import com.util.ListUtils;

/**
 * 链表反转
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode list = Data.generateList(10);
        ListUtils.printList(list);
        ListUtils.printList(reverseList(list));
    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) return head;
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
