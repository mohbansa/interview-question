package greedy;
/*
* Higher rating higher holidays.
Scooby's summer vacations are about to start. Scooby and all his school friends are sitting in the class in a single line.
Every one in the class has a rating depending on their performance in InterviewBit contests. Number of holidays a child will get is dependent on the child's relative performance.

The teacher is kind and wants to give atleast one holiday to each child. If two children are sitting next to each other then the child with higher rating should always get more holidays. The teacher however wants to minimize the sum of holidays give to each child. Help the teacher in distributing holidays to children.

Constraints:

Number of children in class 1<='N'<=100000
Rating of each child 1<=R<=100000
Input: Each test case contains an integer array . This array gives the rating of the ith child.

Output: Return a single integer corresponding to the minimum sum of holidays given to children.

Example:

Input:

3 1 2 2
Output:

4
Explanation:

Hence optimal distribution will be 1,2,1.
* */
public class HigherRatingHigherHolidays {
    public int solve(int[] A) {
        int[] res=new int[A.length];
        res[0]=1;
        for(int i=1;i<A.length;i++)
            res[i]=A[i]>A[i-1]?1+res[i-1]:1;
        int sum=res[A.length-1];
        for(int i=res.length-2;i>=0;i--)
        {
            int curr=1;
            if(A[i]>A[i+1])
                curr=res[i+1]+1;
            sum+=Math.max(curr,res[i]);
            res[i]=curr;
        }
        return sum;
    }
}
