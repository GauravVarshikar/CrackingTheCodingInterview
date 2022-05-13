package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Imagine a stack of plates. If the stack gets too high, it might topple.
// Therefore, we would likely start a new stack when the previous stack exceeds some threshold.
// Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several
// stacks and should create a new stack once the previous one exceeds capacity.
// SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack.
// FOLLOW UP
// Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
public class SetOfStacksQuestion {
    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        for(int i=1; i< 111; i++){
            System.out.println("Pushing: " + i);
            setOfStacks.push(i);
        }
        setOfStacks.print();
        for(int i=1; i< 19; i++){
            System.out.println("Popping: " + setOfStacks.pop());
        }
        setOfStacks.print();
    }
}

class SetOfStacks {
    // limit of each stack as well as limit of the total number of stacks in the list
    private int limit = 10;
    // List to store stacks
    private List<Stack<Integer>> stackList = null;
    // pointer to determine the current active stack to push and pop from
    int currentActiveStack = 0;

    public SetOfStacks(){
        stackList = new ArrayList<>();
    }

    // Push a value to the currently active stack
    public void push(int value) {
        //if the list is empty (first push), create a new stack, push the value in it and then add the stack to the list.
        if(stackList.size() == 0) {
            Stack<Integer> stack = new Stack<>();
            stack.push(value);
            stackList.add(currentActiveStack, stack);
        }
        // For subsequent pushes,
        else {
            //first find the current active stack from the list
            Stack<Integer> curStack = stackList.get(currentActiveStack);
            // if the list and the stack both are full, return
            if(stackList.size() == limit && curStack.size() == limit){
                System.out.println("SetOfStacks is completely full");
                return;
            }
            //if current active stack's size is less than limit, push the value in it
            if(curStack.size() < limit) {
                curStack.push(value);
            }
            // if current active stack is full
            else {
                // move the pointer to active stack to the next by incrementing
                currentActiveStack++;
                //Create a new stack object
                Stack<Integer> stack = new Stack<>();
                //push the value in the new stack
                stack.push(value);
                // add the new stack to the list at the new pointer location
                stackList.add(currentActiveStack, stack);
            }
        }
    }

    //Pop value from the current active stack
    public int pop(){
        //Pop only if the list is not empty
        if(currentActiveStack >= 0) {
            // Get the current active stack from the list using the pointer
            Stack<Integer> curStack = stackList.get(currentActiveStack);
            // Store the return value
            int result = curStack.pop();
            // After popping if the current stack is empty, decrement the pointer by 1
            if (curStack.isEmpty()) currentActiveStack--;            return result;
        }
        return -1;
    }

    public void print(){
        for(int in =0; in<stackList.size(); in++){
            System.out.println("Stack at index: " + in + " : " + stackList.get(in));
        }
    }
}