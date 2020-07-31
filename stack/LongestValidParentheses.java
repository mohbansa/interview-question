package stack;

import java.util.Stack;
/*
* Longest valid Parentheses
Problem Description

Given a string A containing just the characters '(' and ')'.

Find the length of the longest valid (well-formed) parentheses substring.



Problem Constraints
1 <= length(A) <= 750000



Input Format
The only argument given is string A.



Output Format
Return the length of the longest valid (well-formed) parentheses substring.



Example Input
Input 1:

 A = "(()"
Input 2:

 A = ")()())"


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 The longest valid parentheses substring is "()", which has length = 2.
Explanation 2:

 The longest valid parentheses substring is "()()", which has length = 4.
 * */
public class LongestValidParentheses {
        public int longestValidParentheses(String A) {
            int max=Integer.MIN_VALUE;
            int count=0;
            int i=0;
            Stack<Integer> st=new Stack<Integer>();
            st.push(-1);
            while(i<A.length())
            {

                if(A.charAt(i)==')')
                {
                    int index=st.pop();
                    if(!st.isEmpty())
                        max=Math.max(max,i-st.peek());
                    else
                        st.push(i);
                }
                else
                {
                    st.push(i);

                }
                i++;

            }

            //System.out.println(A.substring(0,i)+" "+count+" ggg "+max+" "+i);
            return Math.max(max,count);
        }
    }

