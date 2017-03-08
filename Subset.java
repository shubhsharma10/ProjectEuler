// Leetcode problem number: 78 Subsets

public class Subset
{
    public void populateResult(int[] nums,int size,List<Integer> path,List<List<Integer>> result)
    {
        result.add(path);
        for(int i=0;i<size;i++)
        {
            int len = path.size();
            boolean canPass = (len > 0) ? path.get(len-1) < nums[i] : true;
            if(!path.contains(nums[i]) &&  canPass)
            {
                List<Integer> newPath = new ArrayList<Integer>(path);
                newPath.add(nums[i]);
                populateResult(nums,size,newPath,result);
            }
        }
    }
    
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        List<Integer> newList = new ArrayList<Integer>();
        populateResult(nums,nums.length,newList,retList);
        return retList;
    }
}