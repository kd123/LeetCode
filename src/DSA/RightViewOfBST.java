package DSA;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * To print the right view of a binary search tree (BST) in Java,
 * you need to ensure that you traverse the tree level by level
 * and print the last node you encounter at each level.
 * Here is how you can do it using a level-order traversal (BFS approach):
 */

public class RightViewOfBST {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void rightViewOfBST(TreeNode root){
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i=1;i<=n;i++){
                TreeNode temp = queue.poll();
                if(i==n) {
                    System.out.print(temp.data + " ");
                }
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println("Right view of the binary tree:");
        rightViewOfBST(root);
    }
}
