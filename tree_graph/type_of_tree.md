# Types of Trees

A tree is a data structure composed of nodes:
- Each tree has a root node.
- The root node has zero or more child nodes.
- Each child node has zero and more child nodes, and so on.

The tree cannot contain cycles. The nodes may or may not be in a particular order, they could have any data type as values, and they may or may not have links back to their parent node.

A very simple class definition for Node:
```java
class Node {
    public String name;
    public Node[] children;
}
```

## Binary Tree
A binary tree is a tree in which each node has **up to** two children. Not all trees are binary trees. For example, this tree is not a binary tree.

![Not a binary tree](image/no_binary_tree.jpg)