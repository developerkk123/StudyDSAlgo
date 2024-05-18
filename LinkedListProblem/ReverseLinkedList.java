package LinkedListProblem;
import java.util.*;

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


public class ReverseLinkedList {
    public static void printLinkedList(Node head){
        System.out.println("hi linkedlist");
        Node temp = head;
        while (temp != null) {// here confusion is why not temp.next
            // because in iteration temp become temp.next and in Node class node.next = null initially
            System.out.print(temp.data +" -> ");
            temp = temp.next;
        }
    }
    // Naive solution T(c)==> O(2n) and S(c)=>O(n)
    public static Node reverseNode(Node head){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        // take out from stack and add it node
        while(temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }
    // Optimal approach by reversing node 
    //  T(c)==> O(n) and S(c)=>O(1)
    public static Node reverseNodeOptimal(Node head){
        // Node current = head;
        // Node temp = current.next <===== store
        // current.next = prev <========== reverse
        // current = temp <=============== and move
        Node temp = head;
        Node prev = null;
        // four steps to be followed
        while(temp != null){
            // store refrence of second node
            // 'front' to preserve the reference
            Node front = temp.next; //STEP 1

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev; // STEP 0 hint step is require to store
            // Move 'prev' to the current
            // node for the next iteration
            prev = temp; // STEP 4 JUST FOR ITERATION TO KEEP NODE IN FORWARD DIRECTION for single iteration not required this line

            // move current pointer to next to advancing traversal
            temp = front; // STEP 3 MOVE TEMP AHEAD FOR FURTHER OPERATION
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        Node tempHead=  reverseNodeOptimal(head);
        printLinkedList(tempHead);
    }
}
