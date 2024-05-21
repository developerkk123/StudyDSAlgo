package LinkedListProblem;

import java.util.HashMap;

public class LoopInLinkedList {
    public static void detectLoop(Node head){
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int index=0;
        while (temp != null) {
            if(map.containsKey(temp)){
                System.out.println("found = "+ map.get(temp));
                break;
            }else{
                map.put(temp, index++);
            }
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        //  node5.next = node2;
        head.next.next.next.next.next = head.next.next;
        detectLoop(head);
    }
}
