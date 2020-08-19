package twopointer;

import java.util.Arrays;
/*
* Counting Triangles
You are given an array of N non-negative integers, A0, A1 ,..., AN-1. Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn't matter. Any triangle formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4
* */
public class CountingTriangles {
    public int nTriang(int[] A) {
        int c=0;
        int mod=1000000007;
        Arrays.sort(A);
        for(int i=A.length-1;i>=2;i--)
        {
            // System.out.println(i);
            int l=0;
            int r=i-1;
            while(l<r)
            {
                if(A[l]+A[r]>A[i])
                {
                    //means if this true so all A[l+1]...A[r-1],A[r],A[i] will make traingle

                    c=(c+r-l)%mod;
                    //  System.out.println(c+" "+i+" "+l+"  "+r);
                    r--;


                }
                else
                    l++;
            }


        }
        return c;
    }
}
