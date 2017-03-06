// Leetcode problem number 278 : First bad version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVer extends VersionControl
{
    int foundVersion;
    
    public Solution()
    {
        foundVersion = 0;
    }
    
    public void findBadVersion(int min,int max)
    {
        long sum = (long)max + (long)min;
        sum = sum/2;
        int mid = (int)sum;
        
        if(max-min == 1)
        {
            if(!isBadVersion(max))
                foundVersion = min;
            else
            {
                if(isBadVersion(min))
                    foundVersion = min;
                else
                    foundVersion = max;
            }
            return;
        }
        if(max == min)
        {
            foundVersion = max;
            return;
        }
        
        if(isBadVersion(mid))
            findBadVersion(min,mid);
        else
            findBadVersion(mid+1,max);
    }
    
    public int firstBadVersion(int n)
    {
       if(n==1)
       {
           if(isBadVersion(n))
                return 1;
           else 
                return 0;
       }
       
       if(!isBadVersion(n-1) && isBadVersion(n))
            return n;
       
       else if(!isBadVersion(n))
            return 0;
       else
       {
           findBadVersion(1,n);
       }
       return foundVersion;
    }
}