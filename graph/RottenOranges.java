package graph;

import java.util.LinkedList;
import java.util.Queue;
/*
* Rotten Oranges
Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input
Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:


A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output
Output 1:

 4
Output 2:

 -1


Example Explanation
Explanation 1:

 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2:

 Task is impossible
 * */
public class RottenOranges {
    public int solve(int[][] A) {
        Queue<ele> q = new LinkedList<>();
        int r = A.length;
        int c = A[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                if (A[i][j] == 2)
                    q.add(new ele(i, j));
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            boolean flag = false;
            for (int i = 0; i < s; i++) {
                ele e = q.poll();
                int x = e.x;
                int y = e.y;

                if (valid(x - 1, y, r, c) && A[x - 1][y] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    A[x - 1][y] = 2;
                    q.add(new ele(x - 1, y));

                }
                if (valid(x + 1, y, r, c) && A[x + 1][y] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    A[x + 1][y] = 2;
                    q.add(new ele(x + 1, y));

                }
                if (valid(x, y - 1, r, c) && A[x][y - 1] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    A[x][y - 1] = 2;
                    q.add(new ele(x, y - 1));

                }
                if (valid(x, y + 1, r, c) && A[x][y + 1] == 1) {
                    if (!flag) {
                        flag = true;
                        ans++;
                    }
                    A[x][y + 1] = 2;
                    q.add(new ele(x, y + 1));

                }
                // System.out.println(x+" "+y+" "+ans);
            }

            s = q.size();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                if (A[i][j] == 1)
                    return -1;
        }
        return ans;
    }

    public boolean valid(int x, int y, int r, int c) {
        return (x >= 0 && y >= 0 && x < r && y < c);
    }


    class ele {
        int x;
        int y;

        ele(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}