package backtracking;

import java.util.ArrayList;
/*
* Sudoku
Problem Description

Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.

Problem Constraints
N = 9


Input Format
First argument is an array of array of characters representing the Sudoku puzzle.


Output Format
Modify the given input to the required answer.


Example Input
Input 1:

A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]


Example Output
Output 1:

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]


Example Explanation
Explanation 1:

Look at the diagrams given in the question.
* */
public class Sudoku {
        public void solveSudoku(ArrayList<ArrayList<Character>> inp) {
            solve(inp);
            return;
        }

        public static boolean solve( ArrayList<ArrayList<Character>> inp)
        {
            int col=-1;
            int row=-1;
            boolean flag=true;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    if(inp.get(i).get(j)=='.')
                    {
                        row=i;
                        col=j;
                        flag=false;
                        break;
                    }

                }
                if(!flag)
                    break;
            }

            if(flag)
                return true;



            for(int num=1;num<=9;num++)
            {
                char c=(char)(num+'0');

                if(safe(inp,row,col,c))
                {


                    inp.get(row).set(col,c);
                    if(solve(inp))
                        return true;

                    inp.get(row).set(col,'.');
                }
                // System.out.println(row+" "+col+" "+num);

            }



            return false;
        }

        public static boolean safe(ArrayList<ArrayList<Character>> inp, int row, int col,Character num)
        {
            // System.out.println(row+" === "+col+" "+num);
            for(int i=0;i<9;i++)
            {
                if(inp.get(row).get(i)==num)
                    return false;
            }
            for(int i=0;i<9;i++)
            {
                if(inp.get(i).get(col)==num)
                    return false;
            }
            int rs=row-row%3;
            int cs=col-col%3;
            for(int i=rs;i<rs+3;i++)
            {
                for(int j=cs;j<cs+3;j++)
                    if(inp.get(i).get(j)==num)
                        return false;
            }
            return true;

        }



    }

