package hashing;

import java.util.HashMap;
import java.util.Map;
/*
* Find pairs in array whose sum is already present
Given an array A of N distinct and positive elements, the task is to find number of unordered pairs whose sum already exists in given array.

Expected Complexity : n^2

CONSTRAINTS

1 <= N <= 1000
1 <= A[i] <= 10^6 + 5
SAMPLE INPUT

A : [ 3, 4, 2, 6 ,7]
SAMPLE OUTPUT

2
EXPLANATION

The pairs following the conditions are :
(2,4) = 6,
(3,4) = 7
* */
public class FindPairsinArrayWhoseSumisAlreadyPresent {
    public int solve(int[] A) {
        int ans=0;
        for(int i=0;i<A.length;i++)
        {
            Map<Integer,Integer> inp=new HashMap<>();

            for(int j=0;j<A.length;j++)
            {
                if(i!=j)
                {

                    if(A[j]<A[i])
                    {

                        if(!inp.containsKey(A[i]-A[j]))
                            inp.put(A[j],1);
                        else
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
}
