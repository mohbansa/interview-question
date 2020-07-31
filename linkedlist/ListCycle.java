package linkedlist;
/*
* List Cycle
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input :

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.
* */
public class ListCycle {
    public ListNode detectCycle(ListNode A) {
        if(A==null)
            return A;
        ListNode slow=A;

        ListNode fast=A;

        while(slow!=null && fast!=null && fast.next!=null)
        {

            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                break;



        }
        if(slow!=fast )
            return null;

        slow=A;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
            // System.out.println(slow.val+" "+fast.val);
        }
        return slow;

    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
