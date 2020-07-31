package sorting;
/*
* Merge Overlapping Intervals
Problem Description

Given a collection of intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.



Input Format
First argument is a list of intervals.



Output Format
Return the sorted list of intervals after merging all the overlapping intervals.



Example Input
Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output
Output 1:

[1,6],[8,10],[15,18]


Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
* */

import java.util.Collections;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {


        Collections.sort(intervals, new Comparator<Interval>() {
            @Override public int compare(Interval p1, Interval p2)
            {
                return p1.start - p2.start;
            }
        });


        int i=0;
        ArrayList<Interval>  res=new  ArrayList<Interval> ();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for(Interval interval:intervals)
        {
            if(interval.start<=end)
            {
                end=Math.max(interval.end, end);
            }
            else
            {
                res.add(new Interval(start,end));
                start=interval.start;
                end=interval.end;
            }
        }
        res.add(new Interval(start,end));

        return res;

    }
}
