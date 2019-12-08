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