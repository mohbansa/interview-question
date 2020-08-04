package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
* Level Order
Problem Description

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
 * */
public class LevelOrder {

     // Definition for binary tree
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

        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
            ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
            Queue<TreeNode> q=new LinkedList<>();
            if(A!=null)
                q.add(A);
            int n=q.size();
            while(!q.isEmpty())
            {
                ArrayList<Integer> inner=new ArrayList<Integer>();
                for(int i=0;i<n;i++)
                {
                    A=q.poll();
                    inner.add(A.val);
                    if(A.left!=null)
                        q.add(A.left);
                    if(A.right!=null)
                        q.add(A.right);

                }

                n=q.size();
                res.add(inner);

            }
            return res;

        }
    }

