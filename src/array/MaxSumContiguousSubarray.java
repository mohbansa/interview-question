package array;
/*
* Problem Description

Find the contiguous subarray within an array, A of length N which has the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10]
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]


Example Output
Output 1:

 10
Output 2:

 6


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6.
 * */
public class MaxSumContiguousSubarray {
    public int maxSubArray(final int[] A) {

        int n=A.length;
        int[] out=new int[n];
        out[0]=A[0];
        for(int i=1;i<n;i++)
            out[i]=A[i]+out[i-1]> A[i] ? A[i]+out[i-1]:A[i];


        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(out[i],max);
        }
        return max;
    }
}
