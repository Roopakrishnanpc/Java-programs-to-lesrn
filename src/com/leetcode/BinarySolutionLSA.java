package com.leetcode;

// BinaryTreeNode class definition
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
    
}

// Solution class containing the LCA method
public class BinarySolutionLSA {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        // Base case: if the root is null, return null
        if (root == null) {
        	System.out.println("null");
            return null;
        }
        System.out.println(" first hey let's continue");
        // If the current node is one of the nodes we're looking for, return it
        if (root.data == node1 || root.data == node2 || root.data == node3) {
        	System.out.println("root "+ root+"root.data "+root.data);
            return root;
        }
        System.out.println("entering left binary nodes");
        System.out.println("Entered lcaOfThreeNodes(root.left, node1, node2, node3) "  + " left "+ root.left +" root "+ root);

        // Recur for left and right subtrees
        BinaryTreeNode<Integer> leftNode = lcaOfThreeNodes(root.left, node1, node2, node3);
        System.out.println("Completed lcaOfThreeNodes(root.left, node1, node2, node3) " +leftNode + " left "+ root.left +" root "+ root);
        System.out.println("entering right binary nodes");
        System.out.println("Entered lcaOfThreeNodes(root.right, node1, node2, node3) "  + " right "+ root.right + " root "+root);

        BinaryTreeNode<Integer> rightNode = lcaOfThreeNodes(root.right, node1, node2, node3);
        System.out.println("Completed lcaOfThreeNodes(root.right, node1, node2, node3) "+ rightNode  + " right "+ root.right + " root "+root);

        // If both left and right calls returned non-null, the current node is the LCA
        if (leftNode != null && rightNode != null) {
        	System.out.println("second continue "+root.data);
            return root;
        }
        System.out.println("third break point");
        System.out.println("(leftNode != null) ? leftNode : rightNode "+ ((leftNode != null) ? leftNode : rightNode));
        // Return the non-null child
        return (leftNode != null) ? leftNode : rightNode;
    }

    // Main method to run the code
    public static void main(String[] args) {
        // Constructing the binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        root.left.left.left = new BinaryTreeNode<>(8);
        root.left.left.right = new BinaryTreeNode<>(9);
        root.left.right.left = new BinaryTreeNode<>(10);
        root.left.right.right = new BinaryTreeNode<>(11);

        // Example: Find LCA of nodes 8, 9, and 10
        BinaryTreeNode<Integer> lca = lcaOfThreeNodes(root, 8, 9, 10);
        System.out.println("LCA of 8, 9, and 10 is: " + (lca != null ? lca.data : "null")); // Should print 4

        // Example: Find LCA of nodes 2, 3, and 4
        lca = lcaOfThreeNodes(root, 2, 3, 4);
        System.out.println("LCA of 2, 3, and 4 is: " + (lca != null ? lca.data : "null")); // Should print 1
    }
}
