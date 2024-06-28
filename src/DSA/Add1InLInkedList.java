package DSA;

public class Add1InLInkedList {

    public static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static Node reverseList(Node head){
        Node prev= null;
        Node curr = head;
        while(curr !=null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

   public static Node add1ToReverseList(Node head){
        int carry=1;
        Node cur = head;
        while(cur !=null){
            int newVal = cur.value+carry;
            if(newVal==10){
                cur.value=0;
                carry=1;
            }else {
                cur.value = newVal;
                carry=0;
            }
            if(carry==0)
                break;
            if(cur.next==null && carry==1){
                cur.next = new Node(1,null);
                carry=0;
            }
            cur = cur.next;
        }
        return head;
   }

   public static Node add1ToLinkedList(Node head){
        if(head==null)
            return new Node(1,null);
        Node node = null;
        head = reverseList(head);
        node = add1ToReverseList(head);
        node = reverseList(node);
        return node;
   }
    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head = new Node(1,null);
        head.next = new Node(9,null);
        head.next.next = new Node(9,null);
        head.next.next.next = new Node(8,null);

        System.out.print("List is ");
        printList(head);

        head = add1ToLinkedList(head);
        System.out.println();
        System.out.print("Resultant list is ");
        printList(head);
   }
}
