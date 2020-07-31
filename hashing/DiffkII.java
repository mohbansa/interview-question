package hashing;

import java.util.HashMap;
/*
* Diffk II
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
* */
public class DiffkII {
    public int diffPossible(final int[] A, int B) {
        HashMap<Integer,Integer> inp=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++)
        {
            if(!inp.containsKey(A[i]))
                inp.put(A[i],0);
            inp.put(A[i],inp.get(A[i])+1);
        }
        for(int i=0;i<A.length;i++)
        {
            int num=A[i]+B;
            if(inp.containsKey(num))
            {
                if(num==A[i] && inp.get(num)>1)
                    return 1;
                if(num!=A[i])
                    return 1;
            }
        }
        return 0;
    }
}
