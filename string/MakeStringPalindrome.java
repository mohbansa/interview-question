package string;
/*
* Make String Pallindrome
Problem Description

Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.



Problem Constraints
1 <= N <= 106



Input Format
The only argument given is a string A.



Output Format
Return an integer denoting the minimum characters that are needed to be inserted to make the string a palindrome string.



Example Input
Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome.
 * */
public class MakeStringPalindrome {
    public int solve(String A) {

        int c=0;
        while(A.length()>1)

        {
            if(pal(A))
                break;
            c++;
            A=A.substring(0,A.length()-1);
        }
        return c;

    }

    public boolean pal(String A)
    {
        int i=0;
        int j=A.length()-1;
        while(i<j)
        {
            if(A.charAt(i)!=A.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}
