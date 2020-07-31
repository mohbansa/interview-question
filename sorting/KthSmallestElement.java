package sorting;
/*
* Kth Smallest Element
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
First argument is vector A.

Second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.
 * */
public class KthSmallestElement {
        public int kthsmallest(final int[] A, int k) {
            int[] inp=new int[A.length];
            for(int i=0;i<A.length;i++)
                inp[i]=A[i];

            return sort(inp,0,A.length-1,k);


        }
        public  int sort(int arr[], int l, int r, int k)
        {
            if (l <= r)
            {

                int m = partition(arr[r],arr, l,  r);

                if(k-1==m)
                {

                    return arr[m];
                }

                if(k-1<m)
                    return sort(arr, l, m-1,k);

                return sort(arr , m+1, r,k);

            }

            return -1;
        }
        static int partition(int pivot,int a[], int l, int r)
        {


            int j=l-1;
            for(int i=l;i<=r;i++)
            {
                if(pivot>=a[i])
                {
                    j++;
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;

                }
            }



            return j;
        }



    }

