import java.util.*;
import java.lang.*;
import java.io.*;

class DIV
{
	public boolean isDiv(int n)
	{
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int factor = 2;
		int inputNo = n;
		for(factor =2;factor <= inputNo;factor++)
		{
			int count = 0;
			while(n % factor == 0)
			{
				count++;
				//System.out.print(factor+" ");
				n = n/factor;
				//System.out.println(n);
			}
			//System.out.println("About to put "+factor+" and "+count);
			if(count > 0)
				map.put(factor,count);	
		}

		for(Map.Entry<Integer,Integer> e : map.entrySet())
		{
			System.out.println(e.getKey()+" and value is "+e.getValue());
		}

		int size = map.size();
		if(size == 1)
		{
			Collection<Integer> values = map.values();
			//System.out.println(values.toArray()[0]+" is the number");
			if((int)values.toArray()[0] > 1)
				return true;
			else
				return false;
		}
		else
		{
			int prev = 0;
			Collection<Integer> values = map.values();
			int i =0;
			int factorI = 0;
			for(i=0;i<values.size() - 1;i++)
			{
				factorI = (int)values.toArray()[i];
				if(factorI != (int)values.toArray()[i+1] )
					return false;
			}
			if(factorI > 1)
				return true;
			else
				return false;
		}

	}
	public static void main(String[] args)
	{
		DIV dd = new DIV();
		Scanner sc = new Scanner(System.in);
		int tc=  sc.nextInt();
		int i =0 ;
		for(i=0;i<tc;i++)
		{
			int inputNo = sc.nextInt();
			boolean isDiv = dd.isDiv(inputNo);
			if(isDiv)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}