package binarysearch;
/*
* Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A, you should return the smallest good base of A in string format.


Input Format

The only argument given is the string representing A.
Output Format

Return the smallest good base of A in string format.
Constraints

3 <= A <= 10^18
For Example

Input 1:
    A = "13"
Output 1:
    "3"     (13 in base 3 is 111)

Input 2:
    A = "4681"
Output 2:
    "8"     (4681 in base 8 is 11111).
    * */
public class SmallestGoodBase {
        public String solve(String n) {

            long num = Long.valueOf(n);
            int start= (int)(Math.log(num + 1) / Math.log(2));
            //m will be number of 1 in solution
            for (int m =start; m > 2; m--) {

                long l = (long)(Math.pow(num + 1, 1.0 / m));
                long r = (long)(Math.pow(num, 1.0 / (m - 1)));


                //l=minimum value of base for m number of 1
                //r=maximum value of base for m number of 1
                while (l <= r) {
                    long k = l + ((r - l) >> 1);

                    long f = 0L;

                    //calculating value by putting m number of once with md of l and r
                    for (int i = 0; i < m; i++, f = f * k + 1);

                    //if this is equal to num return as m will be mx to min running so this will be answe
                    if (num == f) {
                        return String.valueOf(k);
                    } else if (num < f) {
                        r = k - 1;
                    } else {
                        l = k + 1;
                    }
                }
            }

            return String.valueOf(num - 1);
        }


    }

