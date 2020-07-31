package sorting;

import java.util.HashMap;
/*
* Find The Next
Problem Description

Given an array of integers A of size N. You are given another array of integers B of size Q representing queries.

For ith query, you need to find an integer Z strictly greater than B[i] such that Z is not present in the array A. You need to minimize the value of Z.

Return an array of size Q denoting answer for each query.



Problem Constraints
1 <= N, Q <= 105

1 <= A[i], B[i] <= 109



Input Format
The first argument given is the integer array A.

The second argument given is the integer array B.



Output Format
Return an array of integers denoting answer for each query.



Example Input
Input 1:

 A = [1, 5, 10, 2, 7]
 B = [1, 6, 9, 12, 11]
Input 2:

 A = [7, 14, 9, 6, 11, 12, 14]
 B = [18, 14, 2, 18, 16, 2, 10]


Example Output
Output 1:

 [3, 8, 11, 13, 12]
Output 2:

 [19, 15, 3, 19, 17, 3, 13]


Example Explanation
Explanation 1:

 Query 1: We need to find the just greater number than 1 not present in the array so as 2 is present and 3 is not so we will output 3 for this.
 Query 2: 8 is the just greater element than 6 not present in the array A.
 Query 3: 11 is the just greater element than 9 not present in the array A.
 Query 4: 13 is the just greater element than 12 not present in the array A.
 Query 5: 12 is the just greater element than 11 not present in the array A.
 * */
public class FindTheNext {
    public int[] solve(int[] A, int[] B) {

        HashMap<Integer,Integer> inp=new HashMap<Integer,Integer> ();
        for(int i=0;i<A.length;i++)
            inp.put(A[i],i);

        int[] res=new int[B.length];
        for(int i=0;i<B.length;i++)
        {
            int num=B[i]+1;
            while(inp.containsKey(num))
                num++;
            res[i]=num;
        }
        return res;
    }
}
