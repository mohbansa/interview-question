package recursion;

import java.util.ArrayList;
/*Permutations
Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= N <= 9



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible permutation of the array.



Example Input
A = [1, 2, 3]


Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]


Example Explanation
All the possible permutation of array [1, 2, 3].
*/
public class Permutations {
        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

            return get(new ArrayList<ArrayList<Integer>>(),A,0);
        }

        public ArrayList<ArrayList<Integer>> get(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> A, int pos)
        {

            // System.out.println(A+" "+res);
            if(pos==A.size()-1)

                res.add(new ArrayList<Integer>(A));


            for(int i=pos;i<A.size();i++)
            {

                swap(A,i,pos);
                get(res,A,pos+1);
                swap(A,pos,i);
            }

            return res;
        }

        public static void swap(ArrayList<Integer> A ,int i ,int pos)
        {
            int temp=A.get(i);
            A.set(i,A.get(pos));
            A.set(pos,temp);
        }


    }

