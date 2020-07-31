package string;

import java.util.Stack;
/*
* Same Format String
Given two strings A and B. Check if B contains same characters as that of given string A and in the same order.

Note

 1: A and B contain only UPPERCASE Letters.
2: No two consecutive characters are same in A.
3: You can only use constant amount of extra memory.

Input Format

The first argument given is string A.
The second argument given is string B.
Output Format

Return 1 if B contains same characters as that of given string A and in the same order else return 0.
For Example

Input 1:
    A = "HIRED"
    B = "HHHIIIRRRRREEEEEDDDDD"
Output 1:
    1

Input 2:
    A = "HIRED"
    B = "DDHHHHIIIIRRRRREEEEDDD"
Output 2:
    0
    * */
public class SameFormatString {
    public int solve(final String A, final String B) {
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<B.length();i++)
        {
            if(st.isEmpty())
                st.push(B.charAt(i));

            if(st.peek()!=B.charAt(i))
                st.push(B.charAt(i));
        }
        for(int i=A.length()-1;i>=0;i--)
        {
            if(st.isEmpty())
                return 0;
            if(st.pop()!=A.charAt(i))
                return 0;
        }
        if(st.isEmpty())
            return 1;
        return 0;

    }
}
