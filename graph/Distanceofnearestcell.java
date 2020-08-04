package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
* Distance of nearest cell
Problem Description

Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - y1| + |x2 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i] <= 1



Input Format
The first argument given is the integer matrix A.



Output Format
Return the matrix B.



Example Input
Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1]
       [0, 1, 1, 0]
     ]
Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]
     ]


Example Output
Output 1:

 [
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]
 ]
Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4]
 ]


Example Explanation
Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
Explanation 2:

 There is only a single 1. Fill the distance from that 1.
 * */
public class Distanceofnearestcell {
        public int[][] solve(int[][] A) {
            int r=A.length;
            int c=A[0].length;
            int[][] res=new int[r][c];
            for(int[] row:res)
                Arrays.fill(row, Integer.MAX_VALUE);
            Queue<Ele> q=new LinkedList<>();
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(A[i][j]==1)
                    {
                        q.add(new Ele(i,j));
                        res[i][j]=0;
                    }
                }
            }

            while(!q.isEmpty())
            {
                Ele e=q.poll();
                int x=e.x;
                int y=e.y;

                if(valid(x-1,y,r,c) && res[x-1][y]>res[x][y]+1){ res[x-1][y]=res[x][y]+1; q.add(new Ele(x-1,y));}
                if(valid(x+1,y,r,c) && res[x+1][y]>res[x][y]+1) { res[x+1][y]=res[x][y]+1; q.add(new Ele(x+1,y));}
                if(valid(x,y-1,r,c) && res[x][y-1]>res[x][y]+1) { res[x][y-1]=res[x][y]+1; q.add(new Ele(x,y-1));}
                if(valid(x,y+1,r,c) && res[x][y+1]>res[x][y]+1) { res[x][y+1]=res[x][y]+1; q.add(new Ele(x,y+1));}


            }
            return res;
        }




        public boolean valid(int x, int y, int r, int c)
        {
            return x>=0 && y>=0 && x<r && y<c;
        }



    class Ele{
        int x;
        int y;
        Ele(int x, int y)
        {
            this.x=x;
            this.y=y;
        }

    }
}
