package com.code;

import com.data.Data;
import com.struct.ListNode;
import com.util.ListUtils;

/**
 * 链表两两反转
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode listNode = Data.generateList(21);
        ListUtils.printList(listNode);
        ListNode reverseList = swapPair(listNode);
        ListUtils.printList(reverseList);
    }

    private static ListNode swapPair(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode current = head, pre = null;
        head = head.next;
        while (current != null && current.next != null){
            ListNode tmp = current.next;
            current.next = tmp.next;
            tmp.next = current;
            if (pre != null){
                pre.next = tmp;
            }
            pre = current;
            current = current.next;
        }

        return head;
    }
}
