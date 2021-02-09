package com.code;

import com.data.Data;
import com.struct.ListNode;
import com.util.ListUtils;

/**
 * 两两交换链表中的节点
 */
public class Q24 {
    public static void main(String[] args) {
        ListNode listNode = Data.generateList(21);
        ListUtils.printList(listNode);
        ListNode reverseList = swapList(listNode);
        ListUtils.printList(reverseList);
    }

    public static ListNode swapList(ListNode head){
        if (head == null) return head;
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
            current = current.next;
        }
        return head;
    }
}
