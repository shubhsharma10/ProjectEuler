// Leetcode problem number : 152
// Problem statement:
// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

// Idea is using DP, at each position we try to find min using number itself and it's predeccesor min,max yet

public class MaxSubarrayProduct
{
    public int maxProduct(int[] nums) 
    {
      int length = nums.length;
      int[] min = new int[length];
      int[] max = new int[length];
      int maxSoFar=0;
      int i=0;
      if(length == 0)
        return 0;
      else if(length == 1)
        return nums[0];
      min[0] = nums[0];
      max[0] = nums[0];
      maxSoFar = nums[0];
      for(i=1;i<length;i++)
      {
         min[i] = Math.min(Math.min(nums[i],min[i-1]*nums[i]),max[i-1]*nums[i]);
         max[i] = Math.max(Math.max(nums[i],min[i-1]*nums[i]),max[i-1]*nums[i]);
         
         if(max[i] > maxSoFar)
            maxSoFar = max[i];
      }
      return maxSoFar;
    }
}