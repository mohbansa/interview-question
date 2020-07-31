package linkedlist;
/*
* Linked-List
Problem Description

Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space.
Note:

If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in new line.


Problem Constraints
1 <= position <= n where, n is the size of the linked-list.



Input Format
First line contains an integer denoting number of cases, let's say t.
Next t line denotes the cases.


Output Format
When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
NOTE: You don't need to return anything.


Example Input
5
i 1 23
i 2 24
p
d 1
p


Example Output
23 24
24


Example Explanation
After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.
* */
public class LinkedList {
    static class Node
    {
        Node next;
        int val;
        Node(int val)
        {
            this.val=val;
            next=null;
        }

    }
    static Node temp=new Node(0);


    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node store=temp;
        while(position>1 && store!=null)
        {

            store=store.next;
            position--;

        }
        Node next=store.next;
        store.next=new Node(value);
        store.next.next=next;
        return ;


    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position==1)
        {
            if(temp.next!=null)
                temp.next=temp.next.next;
            return ;
        }
        Node prev=temp;
        Node curr=temp.next;
        while(position>1 && curr!=null)
        {
            prev=curr;
            curr=curr.next;
            position--;

        }
        if(curr!=null)
            prev.next=curr.next;
        return ;
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node store=temp.next;
        while(store!=null)
        {
            System.out.print(store.val+" ");
            store=store.next;
        }
    }


}
