package com.leetcode.linkedlist;

public class DeleteMiddle {

    void main() {

    }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;

        // Start fast pointer two steps ahead so slow stops right BEFORE the middle node
        ListNode fast = head.next.next;

        while(fast != null &&  fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

}
