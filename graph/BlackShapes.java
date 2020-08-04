package graph;
/*
* Black Shapes
Problem Description

Given character matrix A of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



Problem Constraints
1 <= |A|,|A[0]| <= 1000

A[i][j] = 'X' or 'O'



Input Format
The First and only argument is character matrix A.



Output Format
Return a single integer denoting number of black shapes.



Example Input
Input 1:

 A = [ [X, X, X], [X, X, X], [X, X, X] ]
Input 2:

 A = [ [X, O], [O, X] ]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 All X's belong to single shapes
Explanation 2:

 Both X's belong to different shapes
 * */
public class BlackShapes {
        boolean[][] v;
        public int black(String[] A) {
            int count=0;
            int r=A.length;
            int c=A[0].length();
            v=new boolean[r][c];

            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(A[i].charAt(j)=='X' && !v[i][j]  )
                    {
                        dfs(A,i,j,r,c);
                        count++;
                    }
                }
            }
            return count;
        }

        void dfs(String[] A, int i, int j, int r , int c)
        {
            int row[] = new int[] {  -1, 0, 1,  0 };
            int col[] = new int[] {  0,  1, 0,  -1 };
            // System.out.println(i+" "+j+" "+r+" "+c);
            v[i][j]=true;

            for(int k=0;k<4;k++)
            {
                int r1=i+row[k];
                int c1=j+col[k];


                if(r1 >=0 && c1 >=0 && r1 < r && c1 < c )
                {
                    if(A[r1].charAt(c1)=='X' && !v[r1][c1])
                        dfs(A,r1,c1,r,c);
                }
            }
        }
    }





