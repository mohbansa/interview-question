package linkedlist;
/*
* Intersection of Linked Lists
Problem Description

Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
NOTE:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
The custom input to be given is different than the one explained in the examples. Please be careful.


Problem Constraints
1 <= |A|, |B| <= 106



Input Format
The first argument of input contains a pointer to the head of the linked list A.

The second argument of input contains a pointer to the head of the linked list B.



Output Format
Return a pointer to the node after which the linked list is intersecting.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = [6, 3, 4, 5]
Input 2:

 A = [1, 2, 3]
 B = [4, 5]


Example Output
Output 1:

 [3, 4, 5]
Output 2:

 []


Example Explanation
Explanation 1:

 In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point.
Explanation 2:

 In the second example, the nodes don't have the same values, thus we can return None/Null.
 * */
public class IntersectionofLinkedLists {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int l1=0,l2=0;
        ListNode head1=a;
        ListNode head2=b;
        while(a!=null)
        {
            l1++;
            a=a.next;
        }
        while(b!=null)
        {
            l2++;
            b=b.next;
        }

        if(l1<l2)
        {
            ListNode temp=head1;
            head1=head2;
            head2=temp;
        }
        int i=0;
        while(head1!=null &&i<Math.abs(l2-l1))
        {
            head1=head1.next;
            i++;
        }
        // System.out.println(head1.val+" "+head2.val);
        while(head1!=null && head2!=null)
        {
            if(head1==head2)
                return head1;
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }
    class ListNode {
        int val;
        ListNode next;
        ReverseLinkListII.ListNode random;

        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }
}


