// Leetcode problem number: 106. Construct Binary Tree from Inorder and Postorder Traversal
// Idea: stop when pb > pe 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTreeFromPost
{
    public TreeNode createTree(int[] in, int[] post,int ib,int ie,int pb,int pe,int len)
    {
       if(pb > pe)
            return null;
       
        TreeNode root = new TreeNode(post[pe]);
        int i=ib,index=0;
        while(i < len && post[pe] != in[i])
        {
            i++;
        }
        int cLen = i-ib;
        root.left = createTree(in,post,ib,i-1,pb,pb+cLen-1,len);
        root.right = createTree(in,post,i+1,ie,pb+cLen,pe-1,len);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        int len = postorder.length;
        if(len ==0)
            return null;
        return createTree(inorder,postorder,0,len-1,0,len-1,len);
    }
}