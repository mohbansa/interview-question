package sorting;
/*
* INVERSIONS
Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j

Example:

A : [2, 4, 1, 3, 5]
Output : 3
as the 3 inversions are (2, 1), (4, 1), (4, 3).
* */
public class Inversions {
        public int countInversions(int[] A) {

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
                    while(j1<=r && arr[i1]>arr[j1])
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


