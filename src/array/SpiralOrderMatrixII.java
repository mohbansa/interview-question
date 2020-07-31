package array;
/*
* Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:


Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
* */
public class SpiralOrderMatrixII {
        public int[][] generateMatrix(int A) {

            int c=0;
            int col=A-1;
            int r=0;
            int row=A-1;
            int num=1;
            int[][] a=new int[A][A];
            for(int k=0;k<(int)Math.ceil((double)(a.length/2));k++)
            {
                for(int i=c;i<col;i++)
                {
                    a[r][i]=num;   //00 01
                    num++;
                }


                for(int i=r;i<row;i++)
                {
                    a[i][col]=num; //01 12
                    num++;
                }


                for(int i=col;i>c;i--)
                {
                    a[row][i]=num; //22 21
                    num++;
                }



                for(int i=row;i>r;i--)
                {
                    a[i][c]=num; //20 10
                    num++;
                }

                col--;
                c++;
                r++;
                row--;
                // System.out.println(col+" "+row+" "+c+" "+r);



            }
            if(A%2!=0)
                a[A/2][A/2]=num;
            return a;
        }
    }

