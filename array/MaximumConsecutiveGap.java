package array;
/*
* Problem Description

Given an unsorted integer array A of size N.
Find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
Return 0 if the array contains less than 2 elements.



Problem Constraints
1 <= N <= 106

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum difference.



Example Input
Input 1:

 A = [1, 10, 5]
Input 2:

 A = [10, 9, 10]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 After sorting, the array becomes [1, 5, 10]
 Maximum difference is (10 - 5) = 5.
Explanation 2:

 Maximum difference is (10 - 9) = 1.
 * */
public class MaximumConsecutiveGap {
        public int maximumGap(final int[] A) {
            if(A.length<2)
                return 0;
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            int n=A.length;
            for(int i=0;i<n;i++)
            {
                max=Math.max(max,A[i]);
                min=Math.min(min,A[i]);

            }
            int gap=(int)Math.ceil((double)(max - min)/(n - 1));
            if(gap==0)
                return 0;
            int[]  max_bucket=new int[n];
            int[]  min_bucket=new int[n];
            Arrays.fill(max_bucket,Integer.MIN_VALUE);
            Arrays.fill(min_bucket,Integer.MAX_VALUE);
            for(int i=0;i<n;i++)
            {
                int no=(A[i]-min)/gap;
                max_bucket[no]=Math.max(A[i],max_bucket[no]);
                min_bucket[no]=Math.min(A[i],min_bucket[no]);

            }


            int[] output=new int[2*n];
            int i=0;

            int j=0;
            while(i<n)
            {
                if(min_bucket[i]!=Integer.MAX_VALUE)
                {
                    output[j]=min_bucket[i];j++;


                }

                if(max_bucket[i]!=Integer.MIN_VALUE)
                {
                    output[j]=max_bucket[i];j++;


                }

                i++;

            }
            int ans=Integer.MIN_VALUE;

            for(i=1;i<2*n;i++)
            {
                ans=Math.max(ans,output[i]-output[i-1]);
            }

            // System.out.println(ans);

            return ans;
        }
    }

