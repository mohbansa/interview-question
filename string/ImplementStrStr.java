package string;
/*
* Implement StrStr
Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.
* */
public class ImplementStrStr {
    public int strStr(final String A, final String B) {
        if(A.length()<=0 || B.length()<=0 )
            return -1;
        int j=0,i=0;
        int index=-1;
        while(i<A.length())
        {
            while(i<A.length() && A.charAt(i)!=B.charAt(j))
                i++;
            index=i;

            while(j<B.length() && i< A.length() && A.charAt(i)==B.charAt(j))
            {
                i++;j++;
            }
            if(j==B.length())
                return index;
            else
                j=0;
            i=index+1;
            //System.out.println(i+" "+j);
        }
        return -1;

    }
}
