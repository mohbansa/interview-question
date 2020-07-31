package sorting;
/*
* Reverse pairs
Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of important reverse pairs in the given array A.



Example Input
Input 1:

 A = [1, 3, 2, 3, 1]
Input 2:

 A = [4, 1, 2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:

 There is only one pair i.e (4, 1).
 * */
public class ReversePairs {

        public int solve(int[] A) {
            int c=sort(A,0,A.length-1);
            return c;
        }
        public int  sort(int arr[], int l, int r)
        {
            if (l < r)
            {

                int m = (l+r)/2;


                int c= sort(arr, l, m) + sort(arr , m+1, r);
                int j1=m+1;
                for(int i1=l;i1<=m;i1++)
                {
                    while(j1<=r && arr[i1]>2*arr[j1])
                        j1++;
                    c+=j1-(m+1);
                }

                merge(arr, l, m, r);
                return c;

            }
            else
                return 0;


        }
        public static void merge(int arr[], int l, int m, int r)
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
            int j1=m+1;



            while (i < n1 && j < n2)
            {
                if (L[i] <R[j])
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



    }

