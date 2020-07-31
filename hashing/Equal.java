package hashing;

import java.util.HashMap;
/*
* Equal
Problem Description

Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P,Q,R & S are integers values in the array

NOTE:

1) Return the indices `A1 B1 C1 D1`, so that
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1

2) If there are more than one solutions,
   then return the tuple of values which are lexicographical smallest.

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices in the array )
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 if:
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
If no solution is possible, return an empty list.



Problem Constraints
1 <= N <= 1000

0 <= A[i] <= 1000



Input Format
Single argument which is an integer array A of size N.



Output Format
Return an array of size 4 which indexes of values P,Q,R and S.



Example Input
Input 1:

 A = [3, 4, 7, 1, 2, 9, 8]
Input 2:

 A = [2, 5, 1, 6]


Example Output
Output 1:

 [0, 2, 3, 5]
Output 2:

 [0, 1, 2, 3]


Example Explanation
Explanation 1:

 A[0] + A[2] = A[3] + A[5]
 Note: indexes returned should be 0-based.
Explanation 2:

 A[0] + A[1] = A[2] + A[3]
 * */
public class Equal {
        class pair
        {
            int first, second;
            pair(int f,int s)
            {
                first = f; second = s;
            }
        };

        public int[] equal(int[] A) {
            HashMap<Integer,pair> inp=new  HashMap<Integer,pair>();
            int[] res=new int[4];
            res[0]=Integer.MAX_VALUE;

            for(int i=0;i<A.length-1;i++)
            {
                for(int j=i+1;j<A.length;j++)
                {
                    int sum=A[i]+A[j];
                    if(!inp.containsKey(sum))
                        inp.put(sum,new pair(i,j));
                    else
                    {
                        pair p=inp.get(sum);
                        if(p.first<i && p.second!=i && p.second!=j)
                        {
                            if(res[0]==Integer.MAX_VALUE)
                            {
                                res[0]=p.first;
                                res[1]=p.second;
                                res[2]=i;
                                res[3]=j;
                            }
                            else
                            if(res[0] > p.first ||
                                    res[0] == p.first && res[1] > p.second ||
                                    res[0] == p.first && res[1] == p.second && res[2] >i||
                                    res[0] == p.first && res[0] == p.second && res[2]== i && res[3] >j)
                            {
                                res[0]=p.first;
                                res[1]=p.second;
                                res[2]=i;
                                res[3]=j;
                            }
                        }


                    }
                }
            }


            return res;


        }
    }

