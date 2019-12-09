# Graphs
A tree is actually a type of graph, but not all graphs are tree. Simply put, a tree is a connected graph without cycles.

A graph is simply a collection of nodes with edges between (some of) them.
- Graph can be either directed (like the following graph) or undirected. While directed edges are like a one-way street, undirect edges are like a two-way street.
- The graph might consist of multiple isolated subgraphs. If there is a path between every pair of vertices, it is called a "connected graph"
- The graph can also have cycles (or not). An "acyclic graph" is one without cycles

![Graphs](image/graph.jpg)

In terms of programming, there are two common ways to represent a graph.

## Adjacency List
This is the most common way to represent a graph. Every vertex (or node) stores a list of adjacent vertices. In an undirected graph, an edge like (a, b) would be store twice: once in a's adjacent vertices and once in b's adjacent vertices.

A simple class definition for a graph node could look essentially the same as tree node.
```java
class Graph {
    public Node[] nodes;
}

class Node {
    public String name;
    public Node[] children;
}
```

The graph class is used because, unlike in a tree, you can't necessarily reach all the nodes from a single node.

You don't necessarily need any additional classes to represent a graph. An array (or a hash table) of lists can store the adjacency list. This is bit more compact, but it isn't quite as clean. We tend to use node classes unless there's a compelling reason not to.

## Adjacency Matrices
An adjacency matrix is an NxN boolean matrix (where N is the number of nodes), where a true value at matrix[i][j] indicates an edge from node i to node j. (You can also use an integer matrix with 0s and 1s)

In an undirected graph, an adjacency matrix will be symmetric. In a directed graph, it will not (necessarilly) be.

![Graph](image/graph2.jpg)
||0|1|2|3|
|-|-|-|-|-|
|0|0|1|0|0|
|1|0|0|1|0|
|2|1|0|0|0|
|3|0|0|1|0|
The same graph algorithms that are used on adjacency lists (breath-first search, etc.) can be performed with adjacency matrices, but they may be somewhat less efficient. In the adjacency list representation, you can easily iterate through the neighbors of a node. In the adjacency matrix representation, you will need to iterate through all the nodes to identify a node's neighbors.
