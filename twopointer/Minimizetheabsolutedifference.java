package twopointer;
/*
* Minimize the absolute difference
Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
* */
public class Minimizetheabsolutedifference {
    public int solve(int[] A, int[] B, int[] C) {

        int i=0,j=0,k=0;
        int num=Integer.MAX_VALUE;
        while(i<A.length && j<B.length && k<C.length)
        {
            int max=Math.max(A[i],Math.max(B[j],C[k]));
            int min=Math.min(A[i],Math.min(B[j],C[k]));
            if(min==A[i])
                i++;
            else
            if(min==B[j])
                j++;
            else
                k++;
            num=Math.min(num,Math.abs(max-min));
        }
        return num;

    }
}
