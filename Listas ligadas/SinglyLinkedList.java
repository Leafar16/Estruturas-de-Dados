import java.util.List;
//esta implementacao nao tem em vista o principio do encapsulamneto
public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.head=new ListNode(10);
        ListNode second=new ListNode(8);
        ListNode third=new ListNode(34);
        ListNode fourth=new ListNode(2);

        //Conectar os nodos para formar a lista
        sll.head.next=second; //10 --> 8
        second.next=third;  //10 --> 8 --> 34
        third.next=fourth; //10 --> 8 --> 34 --> 2 --> null


    }
}
