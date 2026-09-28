package com.accentur.ltt;

public class LinkedListExample {
    Node head;

    // Insert new node at end
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Display list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListExample list = new LinkedListExample();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
    }
}

/*Can be replaced with:
LinkedList<Integer> list = new LinkedList<>();
list.add(10);
list.add(20);
list.add(30);
*/