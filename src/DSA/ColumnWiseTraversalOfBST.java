package DSA;

import java.util.*;

public class ColumnWiseTraversalOfBST {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int item) {
            data = item;
            left = right = null;
        }
    }
    public static class TreeNodeWithColumn {
        TreeNode node;
        int column;

        public TreeNodeWithColumn (TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root){
        List<List<Integer>> res= new ArrayList<>();
        if(root == null)
            return res;
        Map<Integer, List<Integer>> columnTable = new TreeMap<>();
        Queue<TreeNodeWithColumn> queue = new LinkedList<>();
        queue.add(new TreeNodeWithColumn(root, 0));
        while(!queue.isEmpty()){
            TreeNodeWithColumn temp = queue.poll();
            int column = temp.column;
            TreeNode node = temp.node;
            columnTable.computeIfAbsent(column, k -> new ArrayList<>()).add(node.data);
            if(node.left != null)
                queue.add(new TreeNodeWithColumn(node.left, column-1));
            if(node.right != null)
                queue.add(new TreeNodeWithColumn(node.right, column+1));
        }
        for(List<Integer> l: columnTable.values())
            res.add(l);
        return res;
    }

    public static void main(String[] args) {
        /*
                 3
                / \
               9   8
              / \ / \
             4  0 1  7
                    / \
                   5   2
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(2);

        List<List<Integer>> result = verticalOrderTraversal(root);

        for (List<Integer> col : result) {
            System.out.println(col);
        }
    }
}
