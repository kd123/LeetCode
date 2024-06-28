package DSA;

/**
 *
 * Find the distance between any two nodes of the tree.
 *
 *
 * ************************ SOLUTION *****************************************
 *
 * To find the distance between any two nodes in a binary tree, you can use the following approach:
 *
 * Find the Lowest Common Ancestor (LCA):
 * The LCA of two nodes is the deepest node that is an ancestor of both nodes.
 * Calculate the Distance:
 * Once you have the LCA, the distance between the two nodes can be
 * calculated as the sum of the distances from the LCA to each node.
 */
public class DistanceBetweenTwoNode {

    public static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    TreeNode root;

    public static TreeNode findLCA(TreeNode root, int n1, int n2){
        if(root== null)
            return null;
        if(root.val == n1 || root.val == n2 )
            return root;
        TreeNode leftLCA = findLCA(root.left, n1,n2);
        TreeNode rightLCA =  findLCA(root.right,n1,n2);
        if(leftLCA != null && rightLCA != null)
            return root;
        return leftLCA !=null ? leftLCA: rightLCA;
    }

    public static int findLevel(TreeNode root, int val, int level){
        if(root== null)
            return -1;
        if(root.val == val)
            return level;
        int leftLevel = findLevel(root.left, val, level+1);
        if(leftLevel == -1)
            return findLevel(root.right, val, level+1);
        return leftLevel;
    }

    public static int findDistanceBetweenTwoNodes(TreeNode root, int n1,int n2){
        TreeNode lca =  findLCA(root,n1,n2);
        if(lca == null)
            return -1;
        int d1 = findLevel(lca, n1,0);
        int d2 = findLevel(lca, n2,0);
        return d1+d2;
    }

    public static void main(String[] args){
        DistanceBetweenTwoNode tree = new DistanceBetweenTwoNode();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        int n1 = 4, n2 = 5;
        System.out.println("Distance between " + n1 + " and " + n2 + " is " + findDistanceBetweenTwoNodes(tree.root, n1, n2));

        n1 = 4;
        n2 = 6;
        System.out.println("Distance between " + n1 + " and " + n2 + " is " + findDistanceBetweenTwoNodes(tree.root, n1, n2));
    }
}
