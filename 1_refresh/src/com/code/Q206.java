package com.code;

import com.data.Data;
import com.struct.ListNode;
import com.util.ListUtils;

/**
 * 链表两两反转
 */
public class Q206 {

    public static void main(String[] args) {
        ListNode list = Data.generateList(12);
        ListUtils.printList(list);
        ListUtils.printList(swapList(list));
    }

    public static final ListNode swapList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;

        ListNode current = head;
        head = head.next;
        while (current != null && current.next != null){
            ListNode tmp = current.next;
            current.next = tmp.next;
            tmp.next = current;
            if (pre != null){
                pre.next = tmp;
            }
            pre = current;
            current = pre.next;
        }
        return head;
    }
}
