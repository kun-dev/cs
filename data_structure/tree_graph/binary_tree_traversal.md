# Binary Tree Traversal
Prior to your interview, you should be comfortable implementing in-order, post-order, and pre-order traversal. The most common of these is in-order traversal.

## In-Order Traversal
In-Order traversal means to "visit"(often print) the left branch, then the current node, and finally, the right branch.
```java
    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            vist(node);
            inOrderTraversal(node.right);
        }
    }
```
When perform on a binary search tree, it visits the nodes in ascending order(hence the name "in-order").

## Pre-Order Traversal
Pre-Order traversal visits the current node before its child nodes (hence the name "pre-order").
```java
    void preOrderTraversal(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
```
In a pre-order traversal, the root is always the first node visited.

## Post-Order Traversal
Post-order traversal visits the current node **AFTER** its child nodes (hence the name "post-order")
```java
    void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }
```
In a post-order traversal, the root is always the last node visited.