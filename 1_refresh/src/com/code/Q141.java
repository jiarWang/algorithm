package com.code;

import com.data.Data;
import com.struct.ListNode;

/**
 * 链表中是否有环
 */
public class Q141 {
    public static void main(String[] args) {
        ListNode list = Data.generateList(12);
        ListNode tail = list;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = list.next.next.next.next.next.next.next.next;
        System.out.println(isCycle(list));
    }

    public static final boolean isCycle(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
