import java.util.List;
//esta implementacao nao tem em vista o principio do encapsulamneto
public class SinglyLinkedList {
    private ListNode head; //inicio da lista ligada

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void printList(){
        ListNode current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    public int lenthList(){
        ListNode current=head;
        int length=0;
        while (current!=null) {
            length++;
            current=current.next;
        }
        return length;
    }

    public void insertNode(int data){ //insere nodo no fim da lista ligada
        ListNode current=head;
        ListNode novo=new ListNode(data);
        while(current.next!=null){
            current=current.next;
        }
        current.next=novo;
    }

    public void insertNodeBeginning(int data){
        ListNode novo=new ListNode(data);
        novo.next=head;
        head=novo;
    }
    
    public void insertAtPosition(int data,int pos){
        ListNode novo=new ListNode(data);
        ListNode previous=head;
        if(pos==0){
            novo.next=head;
            head=novo;
        }else{
        while(pos!=1){ 
            pos--;
            previous=previous.next;
         }
         ListNode next=previous.next;
         previous.next=novo;
         novo.next=next;
        }
    }

    public void deleteFirst(){
        ListNode current=head;
        head=head.next;
        current.next=null;
    }

    public void deleteLast(){
        ListNode current=head;
        while(current.next.next!=null){
            current=current.next;
        }
        current.next=null;
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
        
        sll.insertNode(450);
        sll.insertNodeBeginning(200);
        sll.insertAtPosition(90,3);
        sll.deleteLast();
        sll.printList();
    }
}
