package LinkedListProblem;

public class RotateLinkedList {
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
    static Node rotateList(Node head){
        Node curr = head;
        Node prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        curr.next = head;
        head = curr;
        return head;
        // System.out.println("prev = "+ prev.data);
        // System.out.println("curr = "+ curr.data);
        // System.out.println("head = "+ head.data);

    }
    static Node rotateKtimes(Node head, int k){
        if(head == null || head.next == null) return head;
       // Node temp = head;
            while(k > 0){
                head = rotateList(head);
                k--;
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
        Node temp = head;
        int count =0;
        while(temp != null){
            temp =temp.next;
            count++;
        }
        System.out.println("print = "+ count);
        Node newhea = rotateKtimes(head, 2);
        printLL(newhea);
        int n =3;
        int k = 2000000;
        System.out.println("data = "+ k%n);
    }
}
