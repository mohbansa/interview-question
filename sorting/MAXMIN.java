package sorting;

import java.util.Arrays;
/*
* MAX - MIN
Given an array of integers A and an integer B, find and return the difference of B'th max element and B'th min element of the array A.


Input Format

The first argument given is the integer array A.
The second argument given is integer B.
Output Format

Return the value of B'th max element of A - B'th min element of A.
Constraints

1 <= B <= length of the array <= 100000
-10^9 <= A[i] <= 10^9
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
Output 1:
    2   (4 - 2 = 2)

Input 2:
    A = [5, 17, 100, 11]
    B = 1
Output 2:
    95  (100 - 5 = 95)
    * */
public class MAXMIN {
    public int solve(int[]a, int b) {

        Arrays.sort(a);
        int n=a.length;
        return a[n-b]-a[b-1];

    }
}
