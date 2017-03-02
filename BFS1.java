import java.util.*;
import java.lang.*;

class BFS1
{
	boolean[] visited;
	boolean[] inQueue;
	LinkedList<Node> visiting;

	public BFS1(int len)
	{
		this.visited = new boolean[len];
		this.visiting = new LinkedList<Node>();
		this.inQueue = new boolean[len];
		Arrays.fill(this.visited,false);
		Arrays.fill(this.inQueue,false);
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

	public Node createNode(int val)
	{
		return new Node(val);
	}

	public void addEdge(List<Node> nodeList,int a,int b)
	{
		Node aNode = nodeList.get(a);
		Node bNode = nodeList.get(b);
		if(!aNode.nbrList.contains(b))
			aNode.nbrList.add(b);
		if(!bNode.nbrList.contains(a))
			bNode.nbrList.add(a);
	}

	public int doBFS(int index,List<Node> nodeList)
	{
		if(visited[index])
			return 0;
		int count =0;
		Node start = nodeList.get(index);
		visiting.addLast(start);
		inQueue[index] = true;
		count++;

		while(!visiting.isEmpty())
		{
			Node tp = visiting.removeFirst();
			for(Integer x : tp.nbrList)
			{
				Node nbrNode = nodeList.get(x);
				if(!visited[x] && !visiting.contains(nbrNode))
				{
					//System.out.println(nbrNode.val);
					visiting.addLast(nbrNode);
					count++;
				}
			}
			visited[tp.val] = true;
		}
		return count;
	}

	public static void main(String[] args)
	{
		int len=8;
		BFS1 st = new BFS1(len);
		int i=0;		
		List<Node> nodeList = new ArrayList<Node>();
		for(i=0;i<len;i++)
			nodeList.add(st.createNode(i));

		st.addEdge(nodeList,0,2);
		st.addEdge(nodeList,2,4);
		st.addEdge(nodeList,3,2);
		st.addEdge(nodeList,0,5);
		st.addEdge(nodeList,5,2);
		st.addEdge(nodeList,1,6);
		st.addEdge(nodeList,6,7);
		int tc =0;
		for(i=0;i<len;i++)
			System.out.println(st.doBFS(i,nodeList));
	}
}