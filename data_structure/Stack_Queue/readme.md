# Stacks and Queues

## Implementing of Stack
A stack uses LIFO (last-in first-out) ordering. That is, as in a stack of dinner plates, the most recent item added to the stack is the first item to be removed.

It uses the following operations:
- pop(): remove the top item from the stack
- push(item): add an item to the top of stack
- peek(): return the top of the stack
- isEmpty(): return true if and only if the stack is empty

Unlike an array, a stack does not offer constant-time access to the ith item. However, it does allow constant time adds and removes, as it doesn't require shifting elements around.

## Stack Implementation - linked list
```java
public statck MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null?
    }
}
```

One case where stacks are often useful is in certain recursive algorithm. Sometimes you need to push temporary data onto stack as you recurse, but then remove them as you **backtrack** (for example, because the recursive check failed). A stack offers an intuitive way to do this.

## Implementing a Queue
A queue implements FIFO (first-in first-out) ordering. As in a line or queue at a ticket stand, items are removed from the data structure in the same order that they are added.

It uses the operations:
- add(item): Add an item to the end of the list.
- remove(): Remove the first item in the list.
- peek(): Return the top of the queue.
- isEmpty(): Return true if and only if the queue is empty.

A queue can also be implemented with a linked list. In fact, they are essentially the same thing, as long as items are added and removed from opposite sides.

## Queue Implementation - linked list
```java
public class MyQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> t = new QueueNode<T>(item);
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null?
    }
}
```

One place where queues are often used is in breadth-first search or implementing a cache. We used a queue to store a list of the nodes that we need to process. Each time we process a node, we add its adjacent nodes to the back of the queue. This allows us to process nodes in the order in which they are viewed.