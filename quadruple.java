import java.util.*;
import java.lang.*;
import java.io.*;

class quadruple
{
public List<List<Integer>> map = new ArrayList<List<Integer>>();

	public void printPairsEntry()
	{
		int size = map.size();
		for(List<Integer> arrEntry:map)
		{
			for(Integer number: arrEntry)
			{
				System.out.print(number);
				System.out.print(" ");
			}
			System.out.print("$");
		}
	}

	public void findPairsOf2(List<Integer> inputList,int sum)
	{
		System.out.println("Will start finding pair now");
		int listSize = inputList.size();
		int start=0;
		int end = listSize-1;
		int first,last,curSum = 0;
		while(start < end)
		{
			first = inputList.get(start);
			last = inputList.get(end);
			curSum = first+last;
			if(sum > curSum)
			{
				start++;
			}
			else if(sum < curSum)
			{
				end--;
			}
			else
			{
				if(first == 57 && last == 63)
					System.out.println("came here");
				List<Integer> newList = new ArrayList<Integer>(2);
				newList.add(first);
				newList.add(last);
				map.add(newList);
				start++;
				end--;
			}
		}
	} 
	
	public void findPairsOf2(List<Integer> inputList,int sum,int a,int b,int begin)
	{
		int listSize = inputList.size();
		int start=begin;
		int end = listSize-1;
		int first,last,curSum = 0;
		while(start < end)
		{
			first = inputList.get(start);
			last = inputList.get(end);
			curSum = first+last;
			if(sum > curSum)
			{
				start++;
			}
			else if(sum < curSum)
			{
				end--;
			}
			else
			{
				
				List<Integer> newList = new ArrayList<Integer>(4);
				newList.add(a);
				newList.add(b);
				newList.add(first);
				newList.add(last);
				if(first == 57 && last == 63 && b == 57 && a == 57)
						System.out.println("came here");
				//newList = mergeSort(newList,0,3);
				boolean isPresent = false;
				for(List<Integer> listA: map)
				{
					isPresent = isPresent || (listA.containsAll(newList) && newList.containsAll(listA));
				}
				if(a == 57 && b == 57 && first == 57 && last == 63 && isPresent)
					System.out.println("entry already exists");
				if(!isPresent)
				{
					if(first == 57 && last == 63 && a == 57 && b == 57)
						System.out.println("came here");
					map.add(newList);
				}
				//map.add(newList);
				start++;
				end--;
			}
		}
	} 

	public void findPairsOf3(List<Integer> inputList,int sum,int a,int begin)
	{
		int listSize = inputList.size();
		
		int i=0;
		for(i=begin;i<listSize-2;i++)
		{
			int b = inputList.get(i);
			System.out.println(String.format("b is %d",b));
			if(b <= sum)
			{
			    int newSum = sum - b;
			    findPairsOf2(inputList,newSum,a,b,i+1);
			}
		}
	} 

	public void findPairsOf4(List<Integer> inputList,int sum)
	{
		int listSize = inputList.size();
		int i=0;
		for(i=0;i<listSize-3;i++)
		{
			int a = inputList.get(i);
			System.out.println(String.format("a is %d",a));
			if(a <= sum)
			{
			    int newSum = sum - a;
			    findPairsOf3(inputList,newSum,a,i+1);
			}
		}
	}

	public List<Integer> removeDuplicate(List<Integer> inputArr)
	{
		List<Integer> newL = new ArrayList<Integer>();
		int i =0;
		for(Integer x: inputArr)
		{
			if(i != 0)
			{
				if(newL.get(i-1) != x)
					newL.add(x);
			}
			else
				newL.add(x);
		}
		return newL;
	}
	
	public List<Integer> merge(List<Integer> list1,List<Integer> list2)
	{
		List<Integer> newList = new ArrayList<Integer>();
		int ptr1 =0;
		int ptr2 =0;
		int l1 = list1.size();
		int l2 = list2.size();
		for(ptr1=0,ptr2=0;ptr1 < l1 && ptr2 < l2;)
		{
			int num1 = list1.get(ptr1);
			int num2 = list2.get(ptr2);
			if(num1 < num2)
			{
				newList.add(num1);
				ptr1++;
			}
			else
			{
				newList.add(num2);
				ptr2++;
			}
		}

		if(ptr1 < l1)
		{
			int i=0;
			for(i=ptr1;i<l1;i++)
			{
				newList.add(list1.get(i));
			}
		}

		if(ptr2 < l2)
		{
			int i=0;
			for(i=ptr2;i<l2;i++)
			{
				newList.add(list2.get(i));
			}
		}
		return newList;
	}

	public List<Integer> mergeSort(List<Integer> inputList,int begin,int end)
	{
		List<Integer> newList = new ArrayList<Integer>();
		int length = end-begin+1;
		if(length > 2)
		{
			int mid = begin + ((end - begin)/2);
			List<Integer> list1 = mergeSort(inputList,begin,mid);
			List<Integer> list2 = mergeSort(inputList,mid+1,end);
			newList = merge(list1,list2);
			return newList;
		}
		else if(length == 2)
		{
			int num1 = inputList.get(begin);
			int num2 = inputList.get(end);
			if(num1 > num2)
			{
				newList.add(num2);
				newList.add(num1);
				return newList;
			}
			else
			{
				newList.add(num1);
				newList.add(num2);
			}
			return newList;
		}
		else
		{
			newList.add(inputList.get(begin));
			return newList;
		}
	}

	public void printList(List<Integer> listVar)
	{
		for(Integer x: listVar)
			System.out.print(String.format(" %d ",x));
		System.out.println();
	}


	public static void main(String[] args)
	{
		quadruple g = new quadruple();
		Scanner sc = new Scanner(System.in);
		String tc = sc.nextLine();
		int testCases = Integer.parseInt(tc);
		int i=0;
		for(i=0;i<testCases;i++)
		{
			String arrayInfo = sc.nextLine();
			String[] aInfo = arrayInfo.split(" ");
			int arrayLen = Integer.parseInt(aInfo[0]);
			int sum = Integer.parseInt(aInfo[1]);

			String arrayStr = sc.nextLine();
			List<Integer> inputArr = new ArrayList<Integer>();
			int k =0;
			String[] aStr = arrayStr.split(" ");
			for(k=0;k<arrayLen;k++)
			{
				inputArr.add(Integer.parseInt(aStr[k]));
			}
			inputArr = g.mergeSort(inputArr,0,arrayLen-1);
			g.printList(inputArr);
			g.findPairsOf4(inputArr,sum);
			g.printPairsEntry();
		}
	}
}