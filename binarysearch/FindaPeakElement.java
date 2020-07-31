package binarysearch;
/*
* Problem Description

Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
 * */
public class FindaPeakElement {
    public int solve(int[] A) {

        int l=0;
        int h=A.length-1;
        return get(A,l,h);
    }
    int get(int[] a, int low, int high)
    {
        if(low<=high)
        {
            int mid=(high+low)/2;
            if(mid==0 || mid==a.length-1)
                return a[mid];
            if(a[mid]<a[mid+1])
                return get(a,mid+1,high);
            else
            if(a[mid]<a[mid-1])
                return get(a,low,mid-1);
            else
                return a[mid];
        }
        return -1;
    }
}
