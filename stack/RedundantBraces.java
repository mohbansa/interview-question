package stack;

import java.util.Stack;
/*
* Redundant Braces
Problem Description

Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Chech whether A has redundant braces or not.

NOTE: A will be always a valid expression.



Problem Constraints
1 <= |A| <= 105



Input Format
The only argument given is string A.



Output Format
Return 1 if A has redundant braces, else return 0.



Example Input
Input 1:

 A = "((a+b))"
Input 2:

 A = "(a+(a+b))"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:

 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 * */
public class RedundantBraces {
    public int braces(String A) {
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='(')
                st.push(i);
            else
            if(A.charAt(i)==')')
            {
                int num=st.pop();
                if(i-num==2)
                    return 1;
                else
                if(!st.isEmpty())
                {
                    if(num-st.peek()==1 && A.charAt(i+1)==')')
                        return 1;
                }
            }
        }
        return 0;
    }
}
