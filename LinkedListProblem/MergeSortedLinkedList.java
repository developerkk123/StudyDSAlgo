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


public class MergeSortedLinkedList {
    public static void printLinkedList(Node head){
        System.out.println("hi linkedlist");
        Node temp = head;
        while (temp != null) {// here confusion is why not temp.next
            // because in iteration temp become temp.next and in Node class node.next = null initially
            System.out.print(temp.data +" -> ");
            temp = temp.next;
        }
    }
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node result = new Node(-1);
        Node temp = result;
        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){ // similar to merge two array 
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; // move temp to next after each iteration
        }
        // point to remaining element either in list1 or list 2
        if(list1 != null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        return result.next; // result.next because doesnt want to print -1;
    }
    public static Node sortLinkedList(Node head){
        // here we will sort linked list using merge sort approach
        // use recursive approach to devide list into 2 sub list
        // and use merge sort
        if(head == null || head.next == null){ // base case of recusrion
            return head;
        }
        // use tortise method to find middle of list and devide into 2 list
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;// create division in list
        Node list1 = sortLinkedList(head);
        Node list2 = sortLinkedList(slow);
       // mergeTwoLists(list1, list2);
        return mergeTwoLists(list1, list2);
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(5);
        head.next.next = new Node(9);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);

       // Node tempHead=  mergeTwoLists(head, head2);
     Node newhead =  sortLinkedList(head);
     printLinkedList(newhead);
    }
}
