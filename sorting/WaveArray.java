package sorting;
/*
* Wave Array
Problem Description

Given an array of integers A, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.



Problem Constraints
1 <= len(A) <= 106
1 <= A[i] <= 106



Input Format
First argument is an integer array A.



Output Format
Return an array arranged in the sequence as described.



Example Input
Input 1:

A = [1, 2, 3, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[2, 1, 4, 3]
Output 2:

[2, 1]


Example Explanation
Explanation 1:

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].
Explanation 1:

Only possible answer is [2, 1].
* */
public class WaveArray {
        public int[] wave(int[] A) {

            A=sort(A,0,A.length-1);

            for(int i=0;i<A.length;i+=2)
            {
                if(i+1<A.length)
                {
                    int temp=A[i];
                    A[i]=A[i+1];
                    A[i+1]=temp;
                }
            }

            return A;
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


        public static int[] sort(int arr[], int l, int r)
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

