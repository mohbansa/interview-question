package linkedlist;
/*Remove Duplicates from Sorted List
Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.



Problem Constraints
0 <= length of linked list <= 106



Input Format
First argument is the head pointer of the linked list.



Output Format
Return the head pointer of the linked list after removing all duplicates.



Example Input
Input 1:

 1->1->2
Input 2:

 1->1->2->3->3


Example Output
Output 1:

 1->2
Output 2:

 1->2->3


Example Explanation
Explanation 1:

 Each element appear only once in 1->2.*/
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp = new ListNode(0);
        temp.next = A;
        ListNode pre = temp;
        ListNode cur = A;
        while (cur != null) {
            while (cur != null && cur.next != null && cur.val == cur.next.val)
                cur = cur.next;
            pre.next = cur;
            pre = pre.next;

            cur = cur.next;
        }
        return temp.next;
    }

    class ListNode {
        int val;
        ListNode next;
        CloneaLinkedList.ListNode random;

        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }
}
