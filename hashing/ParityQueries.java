package hashing;

import java.util.ArrayList;
import java.util.HashMap;
/*
* Parity Queries
Problem Description

Given an empty multiset of integers initially and N queries to perform on it.

+ X — add non-negative integer X to the multiset. Note that there may be many occurrences of the same integer.

- X — delete a single occurrence of non-negative integer X from the multiset. It's guaranteed that there is at least one X in the multiset.

? S — count the number of integers in the multiset (with repetitions) that match some pattern S consisting of 0 and 1.

In the pattern, 0 stands for the even digits, while 1 stands for the odd. Integer X matches the pattern S if the parity of the ith from the right digit in decimal notation matches the ith from the right digit of the pattern.

If the pattern is shorter than this integer, it's supplemented with 0's from the left. Similarly, if the integer is shorter than the pattern, its decimal notation is supplemented with the 0's from the left.

For example, if the pattern is S = 010, then integers 92, 2212, 50, and 414 matches the pattern, while integers 3, 110, 25, and 1030 do not.

Given an array of characters A and an array of Strings B (representing the value of X for each query) of size N each, perform the queries and return the result for every third query in the form of an array of integers.



Problem Constraints
1 <= N <= 105

A[i] = {'+', '-', '?'}

0 <= B[i] <= 1018 (given in the form of string)



Input Format
The first argument given is the character array A.

The second argument given is the String array B.



Output Format
Return the answer for every third query in the form of an array of integers.



Example Input
Input 1:

 A = ['+', '+', '-', '?']
 B = [200, 200, 200, 0]
Input 2:

 A = ['+', '+', '?', '+', '-', '?']
 B = [1, 241, 1, 361, 241, 101]


Example Output
Output 1:

 [1]
Output 2:

 [2, 1]


Example Explanation
Explanation 1:

 Multiset after operation 1 : {200}
 Multiset after operation 2 : {200, 200}
 Multiset after operation 3 : {200}
 As only 1 element i.e. 200 in the multiset matches the pattern 0, thus answer is 1.
Explanation 2:

 Multiset after operation 1 : {1}
 Multiset after operation 2 : {1, 241}
 As both the elements i.e. 1 and 241 in the multiset match the pattern 1, thus answer is 2.
 Multiset after operation 3 : {1, 241, 361}
 Multiset after operation 1 : {1, 361}
 As only 1 element i.e. 361 in the multiset matches the pattern 101, thus answer is 1.
 * */
public class ParityQueries {
        public ArrayList<Integer> solve(ArrayList<Character> A, ArrayList<String> B) {

            HashMap<Long,Integer> binary=new HashMap<Long,Integer>();
            HashMap<String,Integer> number=new HashMap<String,Integer>();
            ArrayList<Integer> res=new ArrayList<Integer>();

            for(int i=0;i<B.size();i++)
            {
                long d=decimal(B.get(i));
                // System.out.println(number);
                // System.out.println(binary);
                if(A.get(i)=='+'){
                    if(!number.containsKey(B.get(i)))
                        number.put(B.get(i),0);
                    number.put(B.get(i),number.get(B.get(i))+1);
                    if(!binary.containsKey(d))
                        binary.put(d,0);
                    binary.put(d,binary.get(d)+1);
                }
                else
                if(A.get(i)=='-'){
                    if(number.containsKey(B.get(i)))
                    {
                        if(number.get(B.get(i))==1)
                            number.remove(B.get(i));
                        else
                            number.put(B.get(i),number.get(B.get(i))-1);

                        if(binary.get(d)==1)
                            binary.remove(d);
                        else
                            binary.put(d,binary.get(d)-1);
                    }

                }
                else
                {
                    if(!binary.containsKey(d))
                        res.add(0);
                    else
                        res.add(binary.get(d));
                }
            }
            return res;

        }

        public long decimal(String a)
        {
            long num=0;
            for(int i=0;i<a.length();i++)
            {
                if(a.charAt(i)=='1' || a.charAt(i)=='3' || a.charAt(i)=='5' || a.charAt(i)=='7' || a.charAt(i)=='9' )
                    num+=Math.pow(2,a.length()-1-i);
            }
            return num;
        }
    }

