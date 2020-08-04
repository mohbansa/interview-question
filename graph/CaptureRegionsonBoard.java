package graph;

import java.util.ArrayList;
/*
* Capture Regions on Board
Problem Description

Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Problem Constraints
1 <= N, M <= 1000



Input Format
First and only argument is a N x M character matrix A.



Output Format
Make changes to the the input only as matrix is passed by reference.



Example Input
Input 1:

 A = [
       [X, X, X, X],
       [X, O, O, X],
       [X, X, O, X],
       [X, O, X, X]
     ]
Input 2:

 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]


Example Output
Output 1:

 After running your function, the board should be:
 A = [
       [X, X, X, X],
       [X, X, X, X],
       [X, X, X, X],
       [X, O, X, X]
     ]
Output 2:

 After running your function, the board should be:
 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]


Example Explanation
Explanation 1:

 O in (4,2) is not surrounded by X from below.
Explanation 2:

 No O's are surrounded.
 * */
public class CaptureRegionsonBoard {
        public void solve(ArrayList<ArrayList<Character>> a) {
            int r=a.size();
            int c=a.get(0).size();
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(a.get(i).get(j)=='O')
                        a.get(i).set(j,'-');
                }
            }

            for(int i=0;i<c;i++)
            {
                if(a.get(0).get(i)=='-')
                    flood(a,0,i,r,c,'O','-');
            }

            for(int i=0;i<c;i++)
            {
                if(a.get(r-1).get(i)=='-')
                    flood(a,r-1,i,r,c,'O','-');
            }

            for(int i=0;i<r;i++)
            {
                if(a.get(i).get(0)=='-')
                    flood(a,i,0,r,c,'O','-');
            }

            for(int i=0;i<r;i++)
            {
                if(a.get(i).get(c-1)=='-')
                    flood(a,i,c-1,r,c,'O','-');
            }

            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(a.get(i).get(j)=='-')
                        a.get(i).set(j,'X');
                }
            }

        }

        public static void flood(ArrayList<ArrayList<Character>> a, int i, int j, int  r, int c, char n, char p)
        {
            if(i< 0 || j < 0 || i >=r || j>=c )
                return;
            if(a.get(i).get(j)!=p) return ;
            a.get(i).set(j,n);
            flood(a,i+1,j,r,c,n,p);
            flood(a,i-1,j,r,c,n,p);
            flood(a,i,j+1,r,c,n,p);
            flood(a,i,j-1,r,c,n,p);
            return;

        }
    }

