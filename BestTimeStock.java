// Leetcode problem number: 121 Best time to buy and sell stocks
// Idea: Keep track of mimimum and max difference while iterating array

public class BestTimeStock 
{
    public int maxProfit(int[] prices) 
    {
        int i=0,min=0,max=0,maxSoFar=0;
        int len = prices.length;
        if(len==0)
            return 0;
        min = prices[0];
        for(i=1;i<len;i++)
        {
            if(prices[i] > min)
                max = prices[i] - min;
            if(prices[i] < min)
                min = prices[i];
            if(max > maxSoFar)
                maxSoFar = max;
        }
        
        return maxSoFar;
    }
}