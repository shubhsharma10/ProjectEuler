import java.util.*;
import java.io.*;
import java.lang.*;

class Maxdiff
{
	public static void main(String[] args)
	{
		Maxdiff md = new Maxdiff();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int i,j=0;
		for(i=0;i<tc;i++)
		{
			int len = sc.nextInt();
			List<Integer> ipList = new ArrayList<Integer>();
			for(j=0;j<len;j++)
			{
				ipList.add(sc.nextInt());
			}
			int minValue = ipList.get(0);
			int maxValue = ipList.get(0);
			for(j=1;j<len;j++)
			{
				int oldVal = ipList.get(j);
				int newVal = oldVal - j;
				if(newVal > maxValue)
					maxValue = newVal;
				if(newVal < minValue)
					minValue = newVal;
			}
			int diff = maxValue - minValue;
			System.out.println(diff);
		}
	}
}