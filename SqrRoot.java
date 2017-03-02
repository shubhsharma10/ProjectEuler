import java.util.*;
import java.lang.*;

class SqrRoot
{
	public int findSqrt(int num)
	{
		if(num == 0)
			return 0;
		int left = 1,right = num;
		int mid = 0;

		while(true)
		{
			mid = (left+right)/2;
			if(mid > num/mid)
			{
				right = mid-1;
			}
			else
			{
				if(mid+1 > num/(mid+1))
					return mid;
				left = mid+1;
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		SqrRoot st = new SqrRoot();
		int num = 45;
		int sqrt = st.findSqrt(num);
		System.out.println("Square root of given number is: "+sqrt);
	}
}