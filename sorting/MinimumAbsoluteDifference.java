package sorting;
/*
* Minimum Absolute Difference
Problem Description

Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.



Problem Constraints
1 <= length of the array <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum value of | A[i] - A[j] |.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 1
Output 2:

 6


Example Explanation
Explanation 1:

 The absolute difference between any two adjacent elements is 1, which is the minimum value.
Explanation 2:

 The minimum value is 6 (|11 - 5| or |17 - 11|).
 * */
public class MinimumAbsoluteDifference {
        public int solve(int[] A) {
            A=sort(A,0,A.length-1);
            int min=Integer.MAX_VALUE;
            for(int i=1;i<A.length;i++)
            {
                min=Math.min(min,Math.abs(A[i]-A[i-1]));
            }
            return min;
        }

        public static  void merge(int arr[], int l, int m, int r)
        {

            int n1 = m - l + 1;
            int n2 = r - m;


            int L[] = new int [n1];
            int R[] = new int [n2];


            for (int i=0; i<n1; ++i)
                L[i] = arr[l + i];
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j];



            int i = 0, j = 0;


            int k = l;
            while (i < n1 && j < n2)
            {
                if (L[i] <= R[j])
                {
                    arr[k] = L[i];
                    i++;
                }
                else
                {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }


            while (i < n1)
            {
                arr[k] = L[i];
                i++;
                k++;
            }


            while (j < n2)
            {
                arr[k] = R[j];
                j++;
                k++;
            }
        }


        static int[] sort(int arr[], int l, int r)
        {
            if (l < r)
            {

                int m = (l+r)/2;


                sort(arr, l, m);
                sort(arr , m+1, r);


                merge(arr, l, m, r);
            }
            return arr;
        }
    }

