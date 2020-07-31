package sorting;

import java.util.Arrays;
/*
* B Closest Points to Origin
Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ]
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 * */
public class BClosestPointstoOrigin {
    class pair {
        int X, Y;
        pair(int x, int y) {
            X = x;  Y = y;
        }
    }

    public int[][] solve(int[][] a, int b) {
        int n = a.length;
        pair d[] = new pair[n];
        for(int i = 0; i < n; i++)  d[i] = new pair(a[i][0], a[i][1]);
        Arrays.sort(d, (pair u, pair v) -> {
            long x = 1L * u.X * u.X + 1L * u.Y * u.Y;
            long y = 1L * v.X * v.X + 1L * v.Y * v.Y;
            if(x == y)  return 0;
            return (x < y) ? -1 : 1;
        });
        int ans[][] = new int[b][2];
        for(int i = 0; i < b; i++) {
            ans[i][0] = d[i].X;
            ans[i][1] = d[i].Y;
        }
        return ans;

    }
}
