package graph;

import java.util.LinkedList;
import java.util.Queue;
/*
* Problem Description

Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints
1 <= A, B <= 500



Input Format
The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.



Output Format
If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.



Example Input
Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4


Example Output
Output 1:

 6
Output 2:

 -1


Example Explanation
Explanation 1:

 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.
Explanation 2:

 It is not possible to move knight to position (4, 4) from (2, 1)
 * */
public class KnightOnChessBoard {
        int[][] p={{-2,-1},{2,1},{-2,1},{2,-1},{-1,2},{1,-2},{1,2},{-1,-2}};
        public int knight(int A, int B, int C, int D, int E, int F) {
            boolean[][] visit=new boolean[A+1][B+1];
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{C,D,0});
            visit[C][D]=true;
            while(!q.isEmpty())
            {
                int[] t=q.poll();
                int u=t[0];
                int v=t[1];
                int wt=t[2];
                if(u==E && v==F)
                    return wt;
                for(int i=0;i<p.length;i++)
                {
                    int x=u+p[i][0];
                    int y=v+p[i][1];
                    if(x>0 && y>0 && x<=A && y<=B && !visit[x][y])
                    {
                        visit[x][y]=true;
                        q.add(new int[]{x,y,wt+1});
                    }
                }
            }

            return -1;
        }
    }

