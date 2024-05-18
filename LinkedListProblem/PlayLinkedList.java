package LinkedListProblem;

class Node{
    int data; // data stored in Node
    // Node prev;
    Node next; // pointer to the next node

    // constructor with both data and next as parameter
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    // constructor with only data as a parameter , set next to Null
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class PlayLinkedList {
    public static void printLinkedList(Node head){
        System.out.println("hi linkedlist");
        Node temp = head;
        while (temp != null) {// here confusion is why not temp.next
            // because in iteration temp become temp.next and in Node class node.next = null initially
            System.out.print(temp.data +" -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        printLinkedList(head);
    }
}
