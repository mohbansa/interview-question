package binarysearch;

import java.util.ArrayList;
/*
*Problem Description

Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of the matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd



Input Format
The first and only argument given is the integer matrix A.



Output Format
Return the overall median of the matrix A.



Example Input
Input 1:

A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
Input 2:

A = [   [5, 17, 100]    ]


Example Output
Output 1:

 5
Output 2:

 17


Example Explanation
Explanation 1:


A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
Median is 5. So, we return 5.
Explanation 2:


Median is 17.
* */
public class MatrixMedian {
        public int findMedian(ArrayList<ArrayList<Integer>> a) {

            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            int col=a.get(0).size()-1;
            for(int i=0;i<a.size();i++)
            {
                min=Math.min(min,a.get(i).get(0));
                max=Math.max(max,a.get(i).get(col));
            }

            int actual=(a.size()*a.get(0).size())/2;
            while(min<max)
            {
                System.out.println(min+" "+max);
                int expected=0;
                int mid=(min+max)/2;
                for(int i=0;i<a.size();i++)
                {
                    int b=Arrays.binarySearch(a.get(i).toArray(new Integer[a.get(i).size()]),mid);
                    if(b<0)
                        b=Math.abs(b)-1;
                    else
                    {
                        while(b<a.get(i).size() && a.get(i).get(b)==mid)
                            b++;
                    }
                    expected+=b;
                }

                if(actual<expected)
                    max=mid;
                else
                    min=mid+1;

            }
            return min;

        }
    }

