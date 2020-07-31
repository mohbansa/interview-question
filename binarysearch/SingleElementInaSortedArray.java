package binarysearch;
/*
* Problem Description

Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2


Example Explanation
Explanation 1:

 7 appears once
Explanation 2:

 2 appears once
 * */
public class SingleElementInaSortedArray {
    public int solve(int[] A) {
        int l=0;
        int h=A.length-1;
        return get(A,l,h);
    }

    public int get(int[] a, int low, int high)
    {
        if(low<=high)
        {
            int mid=(low+high)/2;
            if(low==high)
                return a[mid];
            if(mid%2==0)
            {
                if(a[mid]==a[mid+1])
                    return get(a,mid+2,high);
                else
                    return get(a,low,mid);
            }
            else
            {
                if(a[mid]==a[mid-1])
                    return get(a,mid+1,high);
                else
                    return get(a,low,mid-1);
            }

        }
        return -1;
    }
}
