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

public class ReverseLLInGroup {
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
    public static Node reverseLL(Node start, Node end){
        Node curr = start;
        Node prev = null;
        while(curr != end){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node kthNode(Node temp, int k){
        // as we already statring from 1st node
        k = k-1;
        while(temp != null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public static Node kReverseLL(Node head, int k){
        Node temp =head;
        Node prevLast = null;
        while(temp != null){
            //get kth node of current group
            Node kthNode = kthNode(temp, k);
            // if kthnode null means not a complete group
            if(kthNode == null){
                // if there was a prev group link the last node to current node
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }
            // store next node after kth
            Node nextNode = kthNode.next;
            kthNode.next = null;
           Node currentNodetail =  reverseLL(temp, kthNode); // reverse list from temp to kth node
            if(temp == head){
                head = currentNodetail;
            }else{
                prevLast.next = currentNodetail;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        System.out.println("original list :");
        printLL(head);
      //  reverseLL(head);
        System.out.println("node after reversal ");
       // printLL(head);
       Node ewhead = kReverseLL(head, 3);
        System.out.println();
       printLL(ewhead);
    }
}
