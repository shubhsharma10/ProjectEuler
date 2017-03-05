// Leetcode problem number: 102 Binary Level Order Traversal
// Problem statement : Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
// Idea: think of bfs with recursion while queue having all nodes at one level at a time

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryLevelOT 
{
    public void levelTraversal(LinkedList<TreeNode> queue,List<List<Integer>> lol)
    {
        List<Integer> newList = new ArrayList<Integer>();
        LinkedList<TreeNode> newQueue = new LinkedList<TreeNode>();
        
        while(!queue.isEmpty())
        {
            TreeNode temp = (TreeNode)queue.removeFirst();
            if(temp.left != null)
            {
                newQueue.addLast(temp.left);
                newList.add(temp.left.val);
            }
            if(temp.right != null)
            {
                newQueue.addLast(temp.right);
                newList.add(temp.right.val);
            }
        }
        
        if(newList.isEmpty())
            return;
        lol.add(newList);
        levelTraversal(newQueue,lol);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        if(root == null)
            return lol;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list1 = new ArrayList<Integer>();
        
        list1.add(root.val);
        lol.add(list1);
        queue.addLast(root);
        
        levelTraversal(queue,lol);
        return lol;
    }
}