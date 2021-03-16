package com.code;

import com.struct.ListNode;
import com.util.ListUtils;

//链表，两两交换其中相邻的节点
public class Q24 {

    public static void main(String[] args) {
        ListNode list = ListUtils.generateList(10);
        ListUtils.printList(list);
        ListNode swapList = swapPairs(list);
        ListUtils.printList(swapList);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode current = head;
        head = head.next;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;
            if (pre != null) {
                pre.next = next;
            }
            pre = current;
            current = current.next;
        }
        return head;

    }

    public static ListNode swapPairs_(ListNode head){
        if (head == null && head.next == null) return head;
        ListNode pre = null, current = head;
        head = head.next;
        while (current != null && current.next != null){
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;
            if (pre != null){
                pre.next = next;
            }
            pre = current;
            current = current.next;
        }
        return head;
    }
}
