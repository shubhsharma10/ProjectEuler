import java.util.*;
import java.lang.*;
import java.io.*;

class TopSort
{
	boolean[] visited;
	LinkedList<Node> queue;
	Stack topSorted;

	public TopSort(int val)
	{
		visited = new boolean[val];
		queue = new LinkedList<Node>();
		topSorted = new Stack();
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

	public Node createNode(int val)
	{
		return new Node(val);
	}

	public void addEdge(List<Node> nodeList,int src,int dest)
	{
		Node srcNode = nodeList.get(src);
		Node destNode = nodeList.get(dest);

		if(!srcNode.nbrList.contains(dest))
			srcNode.nbrList.add(dest);

		//if(!destNode.nbrList.contains(src))
			//destNode.nbrList.add(src);
	}

	public void doTopSort(List<Node> nodeList,int a)
	{
		Node node = nodeList.get(a);
		if(visited[a])
			return;
		queue.addLast(node);
		while(!queue.isEmpty())
		{
			Node tr = queue.removeFirst();
			for(Integer x: tr.nbrList)
			{
				Node nbr = nodeList.get(x);
				if(!visited[nbr.val] && !queue.contains(nbr))
				{
					queue.addLast(nbr);
				}
			}
			visited[tr.val] = true;
			topSorted.push(tr.val);
		}
	}

	public void printStack()
	{
		int i=0;
		int stackLen = topSorted.size();
		for(i=0;i<stackLen;i++)
			System.out.print(" "+topSorted.pop());
	}

	public static void main(String[] args)
	{
		int len=8;
		TopSort st = new TopSort(len);
		int i=0;		
		List<Node> nodeList = new ArrayList<Node>();
		for(i=0;i<len;i++)
			nodeList.add(st.createNode(i));

		st.addEdge(nodeList,0,2);
		st.addEdge(nodeList,2,4);
		st.addEdge(nodeList,3,2);
		st.addEdge(nodeList,0,5);
		//st.addEdge(nodeList,5,2);
		st.addEdge(nodeList,1,6);
		st.addEdge(nodeList,6,7);
		int tc =0;
		for(i=0;i<len;i++)
			st.doTopSort(nodeList,i);
		st.printStack();
	}
}