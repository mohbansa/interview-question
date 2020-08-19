package trees;
import java.util.ArrayList;
import java.util.Stack;
/*
* Inorder Traversal
Problem Description

Given a binary tree, return the inorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the inorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 * */
public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> st=new Stack<>();
        while(true)
        {
            while(A!=null)
            {
                st.push(A);
                A=A.left;
            }
            if(st.isEmpty())
                return res;
            A=st.pop();
            res.add(A.val);
            A=A.right;
        }

    }
    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) {
        val = x;
        left=null;
        right=null;
       }
  }
}
