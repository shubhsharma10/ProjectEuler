// Leetcode problem number : 15 3Sum
// Idea: two pointer


public class 3Sum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i =0,j=0;
        int sum = 0;
        int len = nums.length;
        for(i=0;i<len-2;i++)
        {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            sum = 0 - nums[i];
            int st = i+1;
            int end = len-1;
            while(st < end)
            {
                int num1 = nums[st];
                int num2 = nums[end];
                if((num1+num2) < sum)
                    st++;
                else if((num1+num2) > sum)
                    end--;
                else
                {
                    result.add(Arrays.asList(nums[i],num1,num2));
                    while(st < end && nums[st] == nums[st+1])
                        st++;
                    while(st < end && nums[end] == nums[end-1])
                        end--;
                    st++;
                    end--;
                }
            }
        }
        return result;
    }
}