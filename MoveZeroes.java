// This is for Leetcode problem number : 283
// Problem statement :  
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
// Note:
// You must do this in-place without making a copy of the array.

public class MoveZeroes 
{
    public void moveZeroes(int[] nums) 
    {
        if(nums.length <= 1)
            return;
        int i=0,j=1;
        int temp=0;
        int len = nums.length;
        for(i=0,j=1;i<len && j < len;)
        {
            if(nums[i] != 0 && nums[j] == 0)
            {
                i++;
                j++;
            }
            else if(nums[i] == 0 && nums[j] != 0)
            {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            else if(nums[i] == 0 && nums[j] == 0)
            {
                j++;
            }
            else
            {
                i++;
                j++;
            }
        }
    }
}