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
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);


        //
        Node head2 = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        Node tempHead=  mergeTwoLists(head, head2);
        printLinkedList(tempHead);
    }
}
