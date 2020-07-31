package hashing;

import java.util.HashMap;
/*
* Largest Continuous Sequence Zero Sum
Problem Description

Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints
1 <= N <= 106

-107 <= A[i] <= 107



Input Format
Single argument which is an integer array A.



Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.



Example Input
A = [1,2,-2,4,-4]


Example Output
[2,-2,4,-4]


Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.
* */
public class LargestContinuousSequenceZeroSum {
    public int[] lszero(int[] A) {
        HashMap<Long,Integer> inp=new HashMap<Long,Integer>();
        long[] B=new long[A.length];
        B[0]=A[0];
        for(int i=1;i<A.length;i++)
            B[i]=A[i]+B[i-1];
        inp.put(0L,-1);
        int count=0;
        int start=0;
        int end=0;
        for(int i=0;i<A.length;i++)
        {
            if(inp.containsKey(B[i]))
            {
                if(i-inp.get(B[i])>count)
                {
                    count=i-inp.get(B[i]);
                    start=inp.get(B[i]);
                    end=i;

                }
            }
            else
                inp.put(B[i],i);
        }
        return Arrays.copyOfRange(A,start+1,end+1);
    }
}
