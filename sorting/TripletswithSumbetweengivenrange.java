package sorting;
/*
* Triplets with Sum between given range
Given an array of real numbers greater than zero in form of strings. Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . Return 1 for true or 0 for false.

Example:
Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
* */
public class TripletswithSumbetweengivenrange {
        public int solve(String[] A) {

            if(A.length<3)
                return 0;
            double[] inp=new double[A.length];
            for(int i=0;i<A.length;i++)
                inp[i]=Double.parseDouble(A[i]);
            double a=inp[0];
            double b=inp[1];
            double c=inp[2];
            if(a+b+c > 1 && a+b+c <2)
                return 1;
            for(int i=3;i<A.length;i++)
            {
                //System.out.println(a+b+c+" "+a+" "+b+" "+c+" "+i);
                if(a+b+c<1)
                {
                    if(a<b && a<c)
                        a=inp[i];
                    else
                    if(b<c)
                        b=inp[i];
                    else
                        c=inp[i];
                }
                else
                if(a+b+c>2)
                {
                    if(a>b && a>c)
                        a=inp[i];
                    else
                    if(b>c)
                        b=inp[i];
                    else
                        c=inp[i];
                }
                else
                    return 1;

            }
            if(a+b+c > 1 && a+b+c <2)
                return 1;
            return 0;
        }
    }

