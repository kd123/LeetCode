package DSA;

/**
 * How do you check that a given binary tree is a valid balanced binary search tree?
 *
 * ******************************* SOL ****************************************************************
 *
 * To check whether a given binary tree is a valid balanced binary search tree (BST),
 * you need to verify two main properties:
 *
 * Binary Search Tree Property: Each node in the tree follows the BST property,
 * where the left subtree of a node contains only nodes with values less than the node's value,
 * and the right subtree contains only nodes with values greater than the node's value.
 * Balanced Tree Property: The tree is balanced,
 * meaning the difference in height between the left and right subtrees of any node is no more than 1.
 *
 * Steps to Check for a Valid Balanced BST:-
 *
 * 1. Check the Binary Search Tree Property:::
 *
 * To ensure the tree is a valid BST, you can perform an in-order traversal
 * and check that the values are in strictly increasing order. Alternatively,
 * you can recursively check that each node's value is within the valid range,
 * defined by the minimum and maximum values allowed for that node.
 *
 * 2. Check the Balanced Tree Property:::
 * To check if the tree is balanced, you can compute the height of the left and right subtrees
 * for each node and ensure that the difference in height is no more than 1.
 *
 *
 * Explanation
 * TreeNode Class: Defines the structure of a tree node with value, left, and right pointers.
 * Result Class: A helper class used to store the result of the recursive check, including whether
 * the subtree is a BST, whether it is balanced, and its height.
 * isBalancedBST Method: This method starts the process and checks
 * if the entire tree is both a BST and balanced.
 * checkBalancedBST Method: This recursive method performs the combined check:
 * If the current node is null, it returns true for both isBST and isBalanced, and height 0.
 * Recursively checks the left and right subtrees.
 * Determines if the current subtree is a BST by ensuring the left subtree values
 * are less than the current node's value and the right subtree values are greater.
 * Determines if the current subtree is balanced by checking the height difference between
 * the left and right subtrees.
 * Computes the height of the current subtree.
 * Returns a Result object with the combined information.
 */




public class IsBalancedBST {

    private static class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static class Result{
        boolean isBST;
        boolean isBalanced;
        int height;
        Result(boolean isBst, boolean isBalanced, int h){
            this.isBST = isBst;
            this.isBalanced = isBalanced;
            this.height = h;
        }
    }

    public static boolean isBalancedBST(TreeNode root){
        return checkBalancedBST(root).isBST && checkBalancedBST(root).isBalanced;
    }

    private static Result checkBalancedBST(TreeNode root){
        if(root == null)
            return new Result(true,true,0);
        Result leftRes = checkBalancedBST(root.left);
        Result rightRes = checkBalancedBST(root.right);
        boolean isBST = leftRes.isBST && rightRes.isBST
                        && (root.left == null || root.left.val < root.val)
                        && (root.right == null || root.right.val >root.val);
        boolean isBalanced = leftRes.isBalanced && rightRes.isBalanced
                            && Math.abs(leftRes.height - rightRes.height) <=1;
        int height = 1+ Math.max(leftRes.height, rightRes.height);
        return new Result(isBST, isBalanced, height);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);

        System.out.println(isBalancedBST(root)); // Should print true for this example tree

    }

}
