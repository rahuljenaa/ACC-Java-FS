package com.accentur.ltt;

//Simple Stack using Array
public class StackExample {
 private int[] stack = new int[5];
 private int top = -1;

 void push(int data) {
     if (top == stack.length - 1) {
         System.out.println("Stack Overflow");
         return;
     }
     stack[++top] = data;
 }

 int pop() {
     if (top == -1) {
         System.out.println("Stack Underflow");
         return -1;
     }
     return stack[top--];
 }

 void display() {
     System.out.println("Stack elements:");
     for (int i = top; i >= 0; i--)
         System.out.println(stack[i]);
 }

 public static void main(String[] args) {
     StackExample stack = new StackExample();
     stack.push(10);
     stack.push(20);
     stack.push(30);
     stack.display();
     System.out.println("Popped: " + stack.pop());
     stack.display();
 }
}

/*
Can be replaced with:
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);
stack.pop();
*/