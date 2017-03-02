import java.util.*;
import java.lang.*;

class DFS1
{
	boolean[] visited;
	Stack visiting;

	public DFS1(int len)
	{
		visited = new boolean[len];
		visiting = new Stack();
		Arrays.fill(visited,false);
	}

	class Node
	{
		int val;
		List<Integer> nbrList;

		public Node(int val)
		{
			this.val = val;
			this.nbrList = new ArrayList<Integer>();
		}
	}

	public Node createNewNode(int val)
	{
		return new Node(val);
	}

	public void addEdge(List<Node> nodeList,int src,int dest)
	{
		Node srcNode = nodeList.get(src);
		Node destNode = nodeList.get(dest);
		if(!srcNode.nbrList.contains(dest))
			srcNode.nbrList.add(dest);
		if(!destNode.nbrList.contains(src))
			destNode.nbrList.add(src);
	}

	public int doDFS(int nodeI,List<Node> nodeList)
	{
		if(visited[nodeI])
			return 0;
		int count = 0;
		Node src = nodeList.get(nodeI);
		visiting.push(src);
		count++;
		while(!visiting.isEmpty())
		{
			Node tp = (Node)visiting.pop();
			for(Integer x: tp.nbrList)
			{
				Node nbr = nodeList.get(x);
				if(!visited[x] && visiting.search(nbr) < 0)
				{
					visiting.push(nbr);
					count += 1;
				}
			}
			visited[tp.val] = true;
		}
		return count;
	}


	public static void main(String[] args)
	{
		int i=0;
		int len = 8;
		DFS1 st = new DFS1(len);
		List<Node> nodeList = new ArrayList<Node>();
		for(i=0;i<len;i++)
			nodeList.add(st.createNewNode(i));
		st.addEdge(nodeList,0,2);
		st.addEdge(nodeList,2,4);
		st.addEdge(nodeList,3,2);
		st.addEdge(nodeList,0,5);
		st.addEdge(nodeList,5,2);
		st.addEdge(nodeList,1,6);
		st.addEdge(nodeList,6,7);
		List<Integer> subsetLength = new ArrayList<Integer>();
		
		for(i=0;i<len;i++)
		{	
			int tt = st.doDFS(i,nodeList);
			System.out.println(tt);
		}
	}

}