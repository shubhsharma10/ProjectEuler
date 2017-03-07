// MaxHeap: 
// Left and right child are at 2i , 2i+1
// Parent is at i/2;
// After add do bubbleUp: compare with parent if parent smaller than swap
// After delete do sinkDown: compare with child for bigger child, swap with bigger child among left and right

import java.util.*;

class MaxHeap
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

	public static void main(String[] args)
	{
		MaxHeap maxHeap = new MaxHeap(11);
		maxHeap.addToHeap(5);
		maxHeap.addToHeap(4);
		maxHeap.addToHeap(12);
		maxHeap.addToHeap(45);
		maxHeap.addToHeap(1);
		maxHeap.addToHeap(34);
		maxHeap.addToHeap(65);
		maxHeap.addToHeap(37);
		maxHeap.addToHeap(23);
		maxHeap.addToHeap(9);
		maxHeap.addToHeap(28);

		int i =0;
		System.out.println();
		while(i <= 4)
		{
			int maximum = maxHeap.extractMax();
			System.out.println("Maximum number at position "+i+" in array is: "+maximum);
			i++;
		}
	}
}