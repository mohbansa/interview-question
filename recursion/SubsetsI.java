package recursion;

import java.util.ArrayList;
import java.util.Collections;
/*
* Subsets II
Problem Description

Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.


Problem Constraints
0 <= N <= 16



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D vector denoting all the possible subsets.



Example Input
Input 1:

 A = [1, 2, 2]
Input 2:

 A = [1, 1]


Example Output
Output 1:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:

 [
    [],
    [1],
    [1, 1]
 ]


Example Explanation
Explanation 1:

All the subsets of the array [1, 2, 2] in lexicographically sorted order.
* */
public class SubsetsI {
        public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
            Collections.sort(A);
            return get(new ArrayList<ArrayList<Integer>>(),new ArrayList<>(),A,0);
        }
        public ArrayList<ArrayList<Integer>> get(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> inp, ArrayList<Integer> A, int pos)
        {
            res.add(new ArrayList<Integer>(inp));


            for(int i=pos;i<A.size();i++)
            {
                // System..println(check+" "+pos);


                if(check(A,pos,i))
                {

                    inp.add(A.get(i));
                    get(res,inp,A,i+1);
                    inp.remove(inp.size()-1);
                }

            }

            //System.out.println(res);
            return res;
        }

        public  boolean check(ArrayList<Integer> A ,int pos ,int i)
        {
            for(int j=pos;j<i;j++)
                if(A.get(j)==A.get(i)) return false;
            return true;
        }
    }
