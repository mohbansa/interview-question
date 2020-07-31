package hashing;

import java.util.HashMap;
import java.util.HashSet;
/*
* Find Rectangle in binary matrix
Given a binary matrix of integers A of size N x M consisting of only 0 or 1. you need to check whether there exists a square or rectangle in a square whose all four corners are 1. All four corners need to be distinct.

If there exists such rectangle or square return 1, else return 0.


Input Format

The first argument given is the integer matrix A.
Output Format

 Return 1 if there exists such rectangle/square whose all four corners are 1 else return 0.
Constraints

1 <= N, M <= 200
0 <= A[i] <= 1
For Example

Input 1:
    A = [   [0, 1, 1]
            [0, 1, 1]
            [0, 1, 0]   ]
Output 1:
    1
    Explanation 1:
    [ [1, 1]
      [1, 1] ]
      There exists a square whose all corners are 1.

Input 2:
    A = [   [0, 1, 1]
            [0, 0, 1]
            [0, 1, 0]   ]
Output 2:
    0
    * */
public class FindRectangleInBinaryMatrix {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int solve(final int[][] a) {
            HashMap<Integer, HashSet<Integer>> inp=new HashMap<Integer,HashSet<Integer>>();
            int n=a.length;
            int m=a[0].length;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m-1;j++)
                {
                    for(int k=j+1;k<m;k++)
                    {

                        if(a[i][j]==1 && a[i][k]==1)
                        {

                            if(inp.containsKey(j))
                            {
                                if(inp.get(j).contains(k))
                                    return 1;
                            }
                            else
                            {
                                HashSet<Integer> inner=new HashSet<Integer>();
                                inner.add(k);
                                inp.put(j,inner);
                            }
                            if(inp.containsKey(k))
                            {
                                if(inp.get(k).contains(j))
                                    return 1;
                            }
                            else
                            {
                                HashSet<Integer> inner=new HashSet<Integer>();
                                inner.add(j);
                                inp.put(k,inner);
                            }
                        }
                    }
                }
            }
            return 0;
        }
    }

