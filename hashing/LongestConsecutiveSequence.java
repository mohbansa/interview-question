package hashing;

import java.util.HashMap;
/*
* Longest Consecutive Sequence
Problem Description

Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from the array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.



Example Input
Input 1:

A = [100, 4, 200, 1, 3, 2]
Input 2:

A = [2, 1]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:

 The set of consecutive elements will be [1, 2].
 * */
public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] A) {
        HashMap<Integer,Integer> inp=new HashMap<Integer,Integer>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            max=Math.max(max,A[i]);
            min=Math.min(min,A[i]);
            inp.put(A[i],1);
        }
        int count=Integer.MIN_VALUE;
        int num=0;
        for(int i=min;i<=max;i++)
        {

            if(inp.containsKey(i))
                num++;
            else
            {
                count=Math.max(count,num);
                num=0;
            }
        }
        count=Math.max(count,num);
        return count;

    }
}
