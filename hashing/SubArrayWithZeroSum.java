package hashing;

import java.util.HashMap;
/*
* Sub-array with 0 sum
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.
 * */
public class SubArrayWithZeroSum {
    public int solve(int[] A) {
        HashMap<Long,Integer> inp=new HashMap<Long,Integer>();
        long[] B=new long[A.length];
        B[0]=A[0];
        for(int i=1;i<A.length;i++)
            B[i]=A[i]+B[i-1];
        inp.put(0L,-1);
        for(int i=0;i<A.length;i++)
        {
            if(inp.containsKey(B[i]))
                return 1;
            inp.put(B[i],i);
        }
        return 0;

    }
}
