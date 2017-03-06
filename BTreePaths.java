// Leetcode problem number: 257 all paths

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTreePaths 
{
    
    public void getPaths(TreeNode root,String sb,List<String> list)
    {
        if(root.left == null && root.right == null)
        {
            list.add(sb);
        }
        if(root.left != null)
            getPaths(root.left,sb+"->"+root.left.val,list);
        if(root.right != null)
            getPaths(root.right,sb+"->"+root.right.val,list);
    }
    
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> list = new ArrayList<String>();
        String sb = "";
        if(root == null)
            return list;
        sb = sb+root.val;
        getPaths(root,sb,list);
        return list;
    }
}