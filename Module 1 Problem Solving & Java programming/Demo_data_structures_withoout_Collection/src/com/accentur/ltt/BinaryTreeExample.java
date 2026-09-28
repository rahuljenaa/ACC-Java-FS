package com.accentur.ltt;

public class BinaryTreeExample {
    TreeNode root;

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeExample tree = new BinaryTreeExample();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(7);

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);
    }
}

/*
 Can be replaced with:
TreeSet<Integer> tree = new TreeSet<>();
tree.add(10);
tree.add(5);
tree.add(15);
tree.add(2);
tree.add(7);
System.out.println(tree); // Sorted automatically
*/