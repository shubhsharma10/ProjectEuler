// Leetcode problem number: 215: Find kth largest element in array
// Idea : Use max heap or sort array

public class KLargest
{
    public class MaxHeap
    {
    	int[] maxHeapArray;
    	int position;
    	int size;
    
    	public MaxHeap(int size)
    	{
    		this.size = size;
    		maxHeapArray = new int[size+1];
    		Arrays.fill(maxHeapArray,0);
    		position = 1;
    	}
    
    	public void addToHeap(int num)
    	{
    		if(this.position == 1)
    		{
    			maxHeapArray[1] = num;
    			this.position++;
    		}
    		else
    		{
    			maxHeapArray[this.position] = num;			
    			bubbleUp(this.position);
    			this.position++;
    		}
    	}
    
    	public void bubbleUp(int pos)
    	{
    		int pt = pos/2;
    		if(pt > 0 && maxHeapArray[pt] < maxHeapArray[pos])
    		{
    			swap(pt,pos);
    			bubbleUp(pt);
    		}
    	}
    
    	public void swap(int a,int b)
    	{
    		int temp = maxHeapArray[a];
    		maxHeapArray[a] = maxHeapArray[b];
    		maxHeapArray[b] = temp;
    	}
    
    	public int getMaxChildIndex(int pos)
    	{
    		int left = 2*pos;
    		int right = (2*pos) + 1;
    		if(left <= size && right <= size)
    		{
    			if(maxHeapArray[pos] < Math.max(maxHeapArray[left],maxHeapArray[right]))
    				return maxHeapArray[left] < maxHeapArray[right] ? right : left;
    		}
    		else if(left <= size && right > size && maxHeapArray[pos] < maxHeapArray[left])
    		{
    			return left;
    		}
    		else if(right <= size && left > size && maxHeapArray[pos] < maxHeapArray[right])
    			return right;
    		return 0;
    	}
    
    	public void sinkDown(int currPos)
    	{
    		if(currPos <= size)
    		{
    			int index = getMaxChildIndex(currPos);
    			if(index != 0)
    			{
    				swap(currPos,index);
    				sinkDown(index);
    			}
    		}
    	}
    
    	public int extractMax()
    	{
    		int retVal = maxHeapArray[1];
    		this.size--;
    		swap(this.position-1,1);
    		sinkDown(1);
    		this.position--;
    		return retVal;
    	}
    
    	public int peek()
    	{
    		return maxHeapArray[1];
    	}
    
    	public void printMaxHeap()
    	{
    		int i=0;
    		for(i=1;i<this.position;i++)
    			System.out.print(" "+maxHeapArray[i]);
    	}
    }

    public int findKthLargest(int[] nums, int k) 
    {
        MaxHeap maxHeap = new MaxHeap(nums.length);
        int i =0;
        int len = nums.length;
        for(i=0;i<len;i++)
            maxHeap.addToHeap(nums[i]);
        int retVal = 0;
        i = 1;
        while(i <= k)
        {
            retVal = maxHeap.extractMax();
            i++;
        }
        return retVal;
    }
}