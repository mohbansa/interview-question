package sorting;
/*
* Largest Number
Problem Description

Given a array A of non negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
First argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

 A = [3, 30, 34, 5, 9]
 Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

 Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 * */
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(final int[] A) {

        String[] res=new String[A.length];
        for(int i=0;i<A.length;i++)
            res[i]=String.valueOf(A[i]);
        Comparator<String> c = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(res,c);


        StringBuilder r = new StringBuilder();
        for (String str : res) {
            r.append(str);
        }
        return r.charAt(0) =='0' ? "0": r.toString();
    }
}
