package linkedlist;
/*
* Reorder List
Problem Description

Given a singly linked list A

 A: A0 → A1 → … → An-1 → An
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106



Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [1, 2, 3, 4]


Example Output
Output 1:

 [1, 5, 2, 4, 3]
Output 2:

 [1, 4, 2, 3]


Example Explanation
Explanation 1:

 The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2:

 The array will be arranged to [A0, An, A1, An-1, A2].
 * */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //3 4 5 6
        //Store 5
        //Connect 4 and 6
        // Connect 5 and 4

        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //1 2 3 6 5 4
        //first = 1
        //second = 6
        //preMiddle= 3
        //connect 3 and 5
        //conenct 6 and 2
        //conenct 1 and 6
        //first=3
        //second=5
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
        return head;

    }
}

