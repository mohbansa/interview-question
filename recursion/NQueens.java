package recursion;

import java.util.ArrayList;
/*
* NQueens
Problem Description

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.



Problem Constraints
1 <= A <= 10



Input Format
First argument is an integer n denoting the size of chessboard



Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input
Input 1:

A = 4
Input 2:

A = 1


Example Output
Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation
Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:
* */
public class NQueens {
        public ArrayList<ArrayList<String>> solveNQueens(int a) {

            char[][] inp = new char[a][a];

            for(int i=0;i<a;i++)
                for(int j=0;j<a;j++)
                    inp[i][j]='.';

            return solve(new ArrayList<ArrayList<String>>(),inp, a, 0);

        }

        public ArrayList<ArrayList<String>> solve(ArrayList<ArrayList<String>> res, char[][] inp, int a, int col)
        {

            if(col==a)

            {
                ArrayList<String> out=new ArrayList<String>();
                for(int i=0;i<a;i++)
                    out.add(new String(inp[i]));

                res.add(out);
                return res ;
            }


            for(int i=0;i<a;i++)
            {

                if(safe(inp,i,col))
                {

                    inp[i][col]='Q';

                    solve(res,inp,a,col+1);
                    inp[i][col]='.';

                }
            }
            return res;
        }

        public boolean safe(char[][] inp, int row,int col)
        {

            for(int i=0;i<col;i++)
                if(inp[row][i]=='Q')
                    return false;
            for(int i=row,j=col;i>=0 && j>=0;i--,j--)
                if(inp[i][j]=='Q')
                    return false;
            for(int i=row,j=col;i<inp.length && j>=0;i++,j--)
                if(inp[i][j]=='Q')
                    return false;
            //System.out.println(row+" "+col);
            return true;
        }
    }

