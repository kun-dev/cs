# Linked List
A linked list is a data structure that represents a sequence of nodes. In a singly linked list, each node points to the next node in the linked list. A doubly linked list gives each node pointers to both the next node and previous node.

Unlike an array, a linked list does not provide constant time access to a particular "index" within the list. This means that if you'd like to find the kth element in the list, you will need to iterate through k elements.

The benefit of a linked list is that you **can add and remove items from the beginning of the list in constant time**. For specific applications, this can be useful.

## Linked List Node
The code below implements a very basic singly linked list:
```java
class Node {
    Node next = null;
    int data;

    public Node(){}
    public Node(int d) {
        this.data = d;
    }

    public appendToTrail(int d) {
        Node end = new Node(d);
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = end;
    }
}
```

## Deleting a Node from a Singly Linked List
Deleting a node from a linked list is fairly straightforward. Given a node n, we find the previous node prev and set prev.next equal to n.next. If the list is doubly linked, we must also upgrade n.next to set n.next.prev equal to n.prev. The important things to remember are:
1. to check for the null pointer and
2. to update the head or tail pointers as necessary
```java
    Node deleteNode(Node head, int d) {
        Node curr = head;
        if (curr.data == d) {
            return head.next; /* moved head */
        }

        while (curr.next != null) {
            if (curr.next.data == d) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }

        return head;
    }
```

## The "Runner" Technique
The "runner" (or second pointer) technique is used in many linked list problems. The runner technique means that you iterate through the linked list with two pointers **simultaneously**, with **one ahead of the other**. The "fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for each one node that the "slow" node iterates through.

For example, suppose you have linked list a1->a2->...->an->b1->b2->...->bn and you wanted to rearrange it into a1->b1->a2->b2->...->an->bn. You do not know the length of the linked list (but you do know that the length is an even number).

You could have one pointer p1 (the fast pointer) move every two elements for every one move that p2 makes. When p1 hits the end of the linked list, p2 will be at the midpoint. Then, move p1 back to the front and begin "weaving" the elements. On each iteration, p2 selects an element and inserts it after p1.