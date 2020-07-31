package array;

import java.util.ArrayList;
/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.



Input Format:

The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:

Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
        */
public class SetMatrixZeros {
        public void setZeroes(ArrayList<ArrayList<Integer>> a) {
            int r=a.size();
            int c=a.get(0).size();

            int[] col=new int[c];
            int[] row=new int[r];

            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(a.get(i).get(j)==0)
                    {
                        col[j]=1;
                        row[i]=1;
                    }
                }
            }

            for(int i=0;i<c;i++)
            {
                if(col[i]==1)
                {
                    for(int j=0;j<r;j++)
                        a.get(j).set(i,0);
                }
            }

            for(int i=0;i<r;i++)
            {
                if(row[i]==1)
                {
                    for(int j=0;j<c;j++)
                        a.get(i).set(j,0);
                }
            }
        }
    }

