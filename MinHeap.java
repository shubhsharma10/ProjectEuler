// MinHeap: 
// Left and right child are at 2i , 2i+1
// Parent is at i/2;
// After add do bubbleUp: compare with parent if parent larger than swap
// After delete do sinkDown: compare with child for smaller child, swap with smaller child among left and right

import java.util.*;

class MinHeap
{
	int[] minHeapArray;
	int position;
	int size;

	public MinHeap(int size)
	{
		this.size = size;
		minHeapArray = new int[size+1];
		Arrays.fill(minHeapArray,0);
		position = 1;
	}

	public void addToHeap(int num)
	{
		if(this.position == 1)
		{
			minHeapArray[1] = num;
			this.position++;
		}
		else
		{
			minHeapArray[this.position] = num;			
			bubbleUp(this.position);
			this.position++;
		}
	}

	public void bubbleUp(int pos)
	{
		int pt = pos/2;
		if(pt > 0 && minHeapArray[pt] > minHeapArray[pos])
		{
			swap(pt,pos);
			bubbleUp(pt);
		}
	}

	public void swap(int a,int b)
	{
		int temp = minHeapArray[a];
		minHeapArray[a] = minHeapArray[b];
		minHeapArray[b] = temp;
	}

	public int getMinChildIndex(int pos)
	{
		int left = 2*pos;
		int right = (2*pos) + 1;
		if(left <= size && right <= size)
		{
			if(minHeapArray[pos] > Math.min(minHeapArray[left],minHeapArray[right]))
				return minHeapArray[left] > minHeapArray[right] ? right : left;
		}
		else if(left <= size && right > size && minHeapArray[pos] > minHeapArray[left])
		{
			return left;
		}
		else if(right <= size && left > size && minHeapArray[pos] > minHeapArray[right])
			return right;
		return 0;
	}

	public void sinkDown(int currPos)
	{
		if(currPos <= size)
		{
			int index = getMinChildIndex(currPos);
			if(index != 0)
			{
				swap(currPos,index);
				sinkDown(index);
			}
		}
	}

	public int extractMin()
	{
		int retVal = minHeapArray[1];
		this.size--;
		swap(this.position-1,1);
		sinkDown(1);
		this.position--;
		return retVal;
	}

	public int peek()
	{
		return minHeapArray[1];
	}

	public void printMinHeap()
	{
		int i=0;
		for(i=1;i<this.position;i++)
			System.out.print(" "+minHeapArray[i]);
	}

	public static void main(String[] args)
	{
		MinHeap minHeap = new MinHeap(11);
		minHeap.addToHeap(5);
		minHeap.addToHeap(4);
		minHeap.addToHeap(12);
		minHeap.addToHeap(45);
		minHeap.addToHeap(1);
		minHeap.addToHeap(34);
		minHeap.addToHeap(65);
		minHeap.addToHeap(37);
		minHeap.addToHeap(23);
		minHeap.addToHeap(9);
		minHeap.addToHeap(28);

		int i =0;
		System.out.println();
		while(i <= 4)
		{
			int minimum = minHeap.extractMin();
			System.out.println("Minimum number at position "+i+" in array is: "+minimum);
			i++;
		}
	}
}