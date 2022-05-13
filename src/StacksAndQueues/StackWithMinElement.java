package StacksAndQueues;

import java.util.Stack;

import static java.util.Collections.max;
import static java.util.Collections.min;

//How would you design a stack which, in addition to push and pop,
// also has a function "min" which returns the minimum element?
// Push, pop and min should all operate in O(1) time

//Simplest and in-built solution is to use Collections.min(stack) function to get the minimum in stack :-)
public class StackWithMinElement {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(4); stack.push(2);stack.push(5);
        stack.push(1); stack.push(3);
        System.out.println("Stack elements: ");
        stack.print();        System.out.println();
        System.out.println("Minimum element in stack: " + stack.min());
        System.out.println("Element Popped: " + stack.pop());
        System.out.println("Minimum element in stack: " + stack.min());
        System.out.println("Element Popped: " + stack.pop());
        System.out.println("Minimum element in stack: " + stack.min());
        stack.push(3);
        System.out.println("Stack elements: ");
        stack.print();        System.out.println();
        System.out.println("Minimum element in stack: " + stack.min());
        System.out.println("Minimum element in stack: " + stack.min());
    }
}

// If it mentioned not to use Collections API, then create a custom class
// Create a new stack that maintains the minimum values, minimum being at the top.
// While popping from the main stack if the value is same as top of minStack, then pop from minStack as well
// Time Complexity = O(1)
// Space Complexity = O(n)
class MyStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MyStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    public void push(int n) {
        stack.push(n);
        if(minStack.isEmpty()) minStack.push(n);
        else if(n < minStack.peek()) {
            minStack.push(n);
        }
    }
    public int pop(){
        if(!stack.isEmpty()) {
            int ret = stack.pop();
            if(ret == minStack.peek()) {
                minStack.pop();
            }
            return ret;
        }
        return -1;
    }
    public int min(){
        return minStack.peek();
    }
    public void print() {
        for(int i: this.stack){
            System.out.print(" " + i);
        }
    }
}
