package graph;
/*
* Number of islands
Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 100

0 <= A[i] <= 1



Input Format
The only argument given is the integer matrix A.



Output Format
Return the number of islands.



Example Input
Input 1:

 A = [
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]
     ]


Example Output
Output 1:

 2
Output 2:

 5


Example Explanation
Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total.
 * */
public class Numberofislands {
        boolean[][] v;
        public int solve(int[][] A) {
            int count=0;
            int r=A.length;
            int c=A[0].length;
            v=new boolean[r][c];

            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(A[i][j]==1 && !v[i][j]  )
                    {
                        dfs(A,i,j,r,c);
                        count++;
                    }
                }
            }
            return count;
        }

        void dfs(int[][] A, int i, int j, int r , int c)
        {
            int row[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
            int col[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
            v[i][j]=true;
            for(int k=0;k<8;k++)
            {
                int r1=i+row[k];
                int c1=j+col[k];

                // System.out.println(r1+" "+c1);
                if(r1 >=0 && c1 >=0 && r1 < r && c1 < c )
                {
                    if(A[r1][c1]==1 && !v[r1][c1])
                        dfs(A,r1,c1,r,c);
                }
            }
        }
    }

