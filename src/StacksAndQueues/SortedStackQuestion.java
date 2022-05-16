package StacksAndQueues;

import java.util.LinkedList;

// Write a program to sort a stack in ascending order. You may use additional stacks to hold items,
// but you may not copy the elements into any other data structures such as an array.
// The stack supports the following operations such as: push, pop, peek and isEmpty
public class SortedStackQuestion {
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(2); sortedStack.print();
        sortedStack.push(4); sortedStack.print();
        sortedStack.push(1); sortedStack.print();
        sortedStack.push(3); sortedStack.print();

        System.out.println(sortedStack.isEmpty());
        System.out.println(sortedStack.peek());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.peek());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.peek());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.peek());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.peek());
    }
}

class SortedStack {
    private LinkedList<Integer> stack = new LinkedList<>();

    public void push(int value) {
        if(stack.isEmpty()){
            stack.push(value);
        }
        else if(value < stack.getFirst()){
            stack.add(0, value);
        }
        else if(value > stack.getLast()){
            stack.add(stack.size(), value);
        }
        else {
            for(int index = 1; index < stack.size(); index++){
                if(value > stack.get(index-1) && value < stack.get(index)) {
                    stack.add(index, value);
                }
            }
        }
    }

    public int pop(){
        if(!stack.isEmpty()) return stack.removeLast();
        else return -1;
    }

    public int peek() {
        if(!stack.isEmpty()) return stack.peekLast();
        else return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void print() {
        System.out.println(stack);
    }
}
