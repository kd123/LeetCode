package DSA;


/**
 * The "top view" of a tree refers to the set of nodes visible when the tree is viewed from above.
 * This means that for each horizontal distance from the root,
 * only the topmost node (i.e.,the first node encountered along that vertical line from top to bottom)
 * is visible.
 *
 * To illustrate the concept, here is a step-by-step explanation and
 * an example of how to determine the top view of a binary tree:
 *
 * Assign Horizontal Distances:
 * Start by assigning a horizontal distance (HD) to each node.
 * The root node has an HD of 0. For any node, its left child has an HD one less than its own HD,
 * and its right child has an HD one more than its own HD.
 *
 * Traverse the Tree:
 * Perform a level-order traversal (BFS) of the tree while keeping track of the horizontal distances.
 * For each horizontal distance, store the first node encountered.
 *
 * Extract Top View:
 * The top view of the tree consists of the nodes stored for each unique horizontal distance,
 * ordered from the smallest to the largest HD.
 *
 * Here's an example of a binary tree and its top view:
 *
 *         1
 *       /   \
 *      2     3
 *     / \   / \
 *    4   5 6   7
 *       /
 *      8
 *
 *
 *      Let's go through the process step-by-step for this tree:
 *
 * Assign horizontal distances:
 *
 * HD(1) = 0
 * HD(2) = -1, HD(3) = +1
 * HD(4) = -2, HD(5) = 0, HD(6) = 0, HD(7) = +2
 * HD(8) = -1
 * Perform level-order traversal:
 *
 * Start with the root (1, HD=0)
 * Move to level 2: nodes (2, HD=-1) and (3, HD=+1)
 * Move to level 3: nodes (4, HD=-2), (5, HD=0), (6, HD=0), and (7, HD=+2)
 * Move to level 4: node (8, HD=-1)
 * Extract the top view:
 *
 * From left to right (smallest to largest HD): nodes with HDs -2, -1, 0, +1, and +2
 * The nodes are: 4, 2, 1, 3, 7
 * Thus, the top view of the binary tree is:
 * 4 2 1 3 7
 *
 * This involves using a level-order traversal (BFS)
 * with the help of a Queue to keep track of nodes and their horizontal distances.
 *
 * Define the TreeNode class.
 * Define the TreeNodeHorizontalDistance class (to store nodes along with their horizontal distances).
 * Implement the topViewOfTree function.
 */

import java.net.Inet4Address;
import java.util.*;

public class TopViewOfTree {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int item) {
            data = item;
            left = right = null;
        }
    }
    public static class TreeNodeHorizontalDistance{
        TreeNode node;
        int hd;

        public TreeNodeHorizontalDistance(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static TreeNode root;
    public static void topViewOfTree(){

        if(root==null)
            return;
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<TreeNodeHorizontalDistance> queue = new LinkedList<>();
        queue.add(new TreeNodeHorizontalDistance(root, 0));
        while (!queue.isEmpty()){
            TreeNodeHorizontalDistance temp = queue.poll();
            int hd = temp.hd;
            TreeNode node = temp.node;
            if(!topViewMap.containsKey(hd)){
                topViewMap.put(hd, node.data);
            }
            if(node.left != null)
                queue.add(new TreeNodeHorizontalDistance(node.left,hd-1));
            if(node.right != null)
                queue.add(new TreeNodeHorizontalDistance(node.right, hd+1));
        }
        for(int data : topViewMap.values()){
            System.out.print(data+" ");
        }
    }
    public static void main(String[] args){

        // Creating the tree given in the example
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);

        System.out.println("Top view of the binary tree:");
        topViewOfTree();
    }

}
