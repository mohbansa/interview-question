package linkedlist;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode temp=new ListNode(0);
        temp.next=A;
        ListNode pre=temp;
        ListNode cur=A;
        while(cur!=null)
        {
            while(cur!=null&& cur.next!=null && cur.val==cur.next.val)
                cur=cur.next;
            if(pre.next==cur)
                pre=pre.next;
            else
                pre.next=cur.next;

            cur=cur.next;
        }

        return temp.next;

    }

class ListNode {
    int val;
    ReverseLinkListII.ListNode next, random;

    ListNode(int x) {
        val = x;
        next = random = null;
    }
}
}
