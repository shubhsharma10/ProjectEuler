import java.lang.*;
import java.util.*;

class MapTest
{
	public static void main(String[] args)
	{
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(1,0);
		map.put(2,5);
		map.put(4,0);
		map.put(7,1);
		map.put(9,3);

		int count = map.values().filter(x -> x == 0).size();
		System.out.println(count);

	}
}