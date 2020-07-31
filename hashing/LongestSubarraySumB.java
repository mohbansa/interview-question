package hashing;

import java.util.HashMap;
/*
* Longest Subarray Sum B
Given an array of integers A of size N and an integer B. Find the length of longest subarray having sum equal to B.

If no such subarray exists then return -1.


Input Format

The First argument given is the integer array A.
The Second argument is an integer B.
Output Format

Return the length of longest subarray having sum equal to B if exists else return -1.
Constraints

1 <= N <= 100000
-10^6 <= A[i] <= 10^6
-10^9 <= B <= 10^9
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 10

Output 1:
    4

Input 2:
    A = [1, -1, -1, 1]
    B = 0
Output 2:
    4
    * */
public class LongestSubarraySumB {
    public int solve(int[] A, int C) {

        int max=-1;
        HashMap<Long, Integer> inp=new HashMap<Long, Integer>();
        long sum=0;
        for(int i=0;i<A.length;i++)
        {
            sum+=A[i];
            if(!inp.containsKey(sum))
                inp.put(sum,i);
            if(sum==C)
                max=i+1;
            if(inp.containsKey(sum-C))
                max=Math.max(max,i-inp.get(sum-C));

        }
        return max;


    }
}
