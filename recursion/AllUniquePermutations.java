package recursion;

import com.sun.source.doctree.SeeTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
* Problem Description

Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible unique permutation of the array.



Example Input
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]


Example Explanation
Explanation 1:

 All the possible unique permutation of array [1, 1, 2].
Explanation 2:

 All the possible unique permutation of array [1, 2].
 * */
public class AllUniquePermutations {
        public static Set<Integer> check=new HashSet<Integer>();
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
                // System.out.println(check+" "+pos);


                if(check(A,pos,i))
                {

                    swap(A,i,pos);
                    get(res,A,pos+1);
                    swap(A,pos,i);
                }



            }

            //System.out.println(res);
            return res;
        }

        public  boolean check(ArrayList<Integer> A ,int pos ,int i)
        {
            // System.out.println(pos+" "+i+" "+A);
            for(int j=pos;j<i;j++)
                if(A.get(j)==A.get(i)) return false;
            return true;
        }

        public static void swap(ArrayList<Integer> A ,int i ,int pos)
        {
            int temp=A.get(i);
            A.set(i,A.get(pos));
            A.set(pos,temp);
        }

}
