package sorting;

import java.util.ArrayList;
import java.util.List;
/*
* Problem Description

Given an array of integers A, find and return new integer array B.

Array B has the property where B[i] is the number of smaller elements to the right of A[i].



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the new integer array B.



Example Input
A = [1, 5, 4, 2, 1]


Example Output
[0, 3, 2, 1, 0]


Example Explanation
Number of smaller elements to the right of 1 are 0.
Number of smaller elements to the right of 5 are 3 (4, 2, 1).
Number of smaller elements to the right of 4 are 2 (2, 1).
Number of smaller elements to the right of 2 are 1 (1).
Number of smaller elements to the right of 1 are 0.
* */
public class Countofsmallernumbersafterself {

        public int[] solve(int[] nums) {

            int[] ans = new int[nums.length];
            List<Integer> sorted = new ArrayList<Integer>();
            for (int i = nums.length - 1; i >= 0; i--) {
                // System.out.println(sorted);
                int index = findIndex(sorted, nums[i]);
                ans[i] = index;
                sorted.add(index, nums[i]);
            }
            return ans;
        }
        private int findIndex(List<Integer> sorted, int target) {
            if (sorted.size() == 0) return 0;
            int start = 0;
            int end = sorted.size() - 1;
            if (sorted.get(end) < target) return end + 1;
            if (sorted.get(start) >= target) return 0;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (sorted.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (sorted.get(start) >= target) return start;
            return end;
        }
    }
