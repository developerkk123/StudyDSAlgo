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
        System.out.println("************ linkedlist ************");
       // Node temp = head;
       // int count=0;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {// here confusion is why not temp.next
            // because in iteration temp become temp.next and in Node class node.next = null initially
            if(slow == fast && slow != head && fast != head){
                System.out.println("slow pointer " + slow.next.data);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

       // System.out.println("count = "+ count);
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        //  node5.next = node2;
        head.next.next.next.next.next = head.next;
        printLinkedList(head);
    }
}
