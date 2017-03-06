// Leetcode problem no. 56: Merge Intervals

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals 
{
    public class MyComparator implements Comparator<Interval>
	{
	    public int compare( Interval x, Interval y )
	    {
	        return x.start - y.start;
	    }
	}
	
	public void checkAndMerge(Interval input,List<Interval> merged)
	{
	    int index = -1,i=0;
	    Interval curr = null;
	    for(i=0;i<merged.size();i++)
	    {
	        curr = merged.get(i);
	        if(input.start >= curr.start && input.start <= curr.end)
	        {
	            index = i;
	            break;
	        }
	    }
	    if(index != -1)
	    {
	        curr.end = Math.max(input.end,curr.end);
	        merged.set(index,curr);
	    }
	    else
	        merged.add(input);
	}

    
    public List<Interval> merge(List<Interval> intervals)
    {
        if(intervals.size() == 0)
            return intervals;
        Collections.sort(intervals,new MyComparator());
        int i =0;
        List<Interval> mergedIntervals = new ArrayList<Interval>();
        mergedIntervals.add(intervals.get(0));
        for(i=1;i<intervals.size();i++)
        {
            checkAndMerge(intervals.get(i),mergedIntervals);
        }
        return mergedIntervals;
    }
}