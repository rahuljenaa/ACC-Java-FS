package com.accentur.ltt;

//Simple Queue using Array
public class QueueExample {
 int[] queue = new int[5];
 int front = -1, rear = -1;

 void enqueue(int data) {
     if (rear == queue.length - 1) {
         System.out.println("Queue Full");
         return;
     }
     if (front == -1) front = 0;
     queue[++rear] = data;
 }

 int dequeue() {
     if (front == -1 || front > rear) {
         System.out.println("Queue Empty");
         return -1;
     }
     return queue[front++];
 }

 void display() {
     System.out.print("Queue elements: ");
     for (int i = front; i <= rear; i++)
         System.out.print(queue[i] + " ");
     System.out.println();
 }

 public static void main(String[] args) {
     QueueExample q = new QueueExample();
     q.enqueue(10);
     q.enqueue(20);
     q.enqueue(30);
     q.display();
     System.out.println("Dequeued: " + q.dequeue());
     q.display();
 }
}

/*
 Can be replaced with:
Queue<Integer> queue = new LinkedList<>();
queue.add(10);
queue.add(20);
queue.add(30);
queue.remove();
*/