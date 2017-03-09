// Leetcode problem number: 230. Kth Smallest Element in a BST
// Idea: Inorder traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class kBST {
    
    public void doInorderTraversal(TreeNode root,List<Integer> qt)
    {
        if(root == null)
            return;
        doInorderTraversal(root.left,qt);
        qt.add(root.val);
        doInorderTraversal(root.right,qt);
    }
    
    public int kthSmallest(TreeNode root, int k) 
    {
        List<Integer> qt = new ArrayList<Integer>();
        doInorderTraversal(root,qt);
        return qt.get(k-1);
    }
}