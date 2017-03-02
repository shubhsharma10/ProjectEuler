import java.lang.*;
import java.io.*;
import java.util.*;

class Equ
{
	public static void main(String[] args)
	{
		Equ eq = new Equ();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int i,j=0;
		for(i=0;i<tc;i++)
		{
			int len = sc.nextInt();
			List<Integer> inputList = new List<Integer>();
			for(j=0;j<len;j++)
			{
				inputList.add(sc.nextInt());
			}

			int st,end=0;
			int sumS,sumE=0;
			sumS = inputList.get(0);
			sumE = inputList.get(len-1);
			for(;end-st > 2;)
			{
				if(sumS > sumE)
				{
					end--;
					sumE += inputList.get(end);
				}
				else
				{
					st++;
					sumS += inputList.get(st);
				}

			}

			if(sumE == sumS)
				System.out.println(" %d ",end-1);
			else
				System.out.println("-1");
		}
	}
}