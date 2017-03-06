// Leetcode problem number : 1 Two sum
// Idea hashmap with desired value as key

public class TwoSum
{
    public int[] twoSum(int[] nums, int target) 
    {
       HashMap<Integer,Integer> dict = new HashMap<Integer,Integer>();
       int i =0;
       dict.put(target-nums[0],0);
       for(i=1;i<nums.length;i++)
       {
         if(dict.containsKey(nums[i]))
            return new int[] {dict.get(nums[i]),i};
            
         dict.put(target-nums[i],i);
       }
       return new int[] {0,0};
    }
}