package trees;

import java.util.ArrayList;
/*
* Binary Tree From Inorder And Postorder
Problem Description

Given inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
 * */
public class BinaryTreeFromInorderAndPostorder {
    int pre=0;
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        pre=B.size()-1;
        return build(A,B, 0, A.size()-1);
    }

    public TreeNode build(ArrayList<Integer> A, ArrayList<Integer> B, int start, int end) {
        if(start> end || pre<0)
            return null;

        TreeNode node=new TreeNode(B.get(pre));
        int index=0;
        for(int i=start;i<=end;i++)
        {

            if(node.val==A.get(i))
            {
                //  System.out.println(i+" "+A.get(i)+" "+node.val);
                index=i;
                break;
            }
        }
        pre--;
        // System.out.println(node.val+" "+start+" "+end+" "+index+" "+A);
        if(start==end)
            return node;

        node.right= build(A,B, index+1,end);
        node.left= build(A,B, start, index-1);


        return node;
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
