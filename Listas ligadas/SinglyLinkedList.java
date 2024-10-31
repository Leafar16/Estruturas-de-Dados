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
        System.out.println("\n");
        while(current!=null){
            System.out.print(current.data + "-->");
            current=current.next;
        }
        System.out.println("null\n");
    }

    public int lengthList(){
        ListNode current=head;
        int length=0;
        while (current!=null) {
            length++;
            current=current.next;
        }
        return length;
    }

    public void insertNode(int data){ //insere nodo no fim da lista ligada
        if(head==null) insertNodeBeginning(data);
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
        if(head==null) return;
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

    public void deleteAtPosition(int  pos){
        if(head==null) return;
        if (pos==0){
            deleteFirst();
        }else{
            ListNode previous=head;
            while (pos!=1){
             previous=previous.next;
             pos--;
             if(previous==null) return;
            }
            ListNode next=previous.next;
            previous.next=next.next;
            next=null;
        }
    }

    public void deleteByKey(int key){
        if(head==null) return;
        ListNode previous=head;

        while(previous.next.data!=key){
            previous=previous.next;
            if(previous.next==null) return;
        }
        ListNode next=previous.next;
        previous.next=next.next;
        next=null;
    }

    public boolean elementExists(int data){
        if(head==null) return false;
        ListNode current=head;
        while(current.data!=data ){
            current=current.next;
            if(current==null) return false;
        }
        return true;
    }

    public void reverseList(){
        if(head==null || head.next==null) return; //se a lista nao tem elementos ou so tem um elemento,nao se efetua alteracoes

        ListNode previous=null;
        ListNode current=head;
        ListNode next=null;

        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        head=previous;
    }

    public ListNode findMiddleNode(){
        if(head==null) return null;

        if(lengthList()%2==0){
            System.err.println("A lista tem nr par de elementos.");
             return null;
            }

        ListNode current=head;
            int c=(lengthList()/2);
        for(int i=0;i<c;i++){
            current=current.next;
        }
        return current;
    }
    
    public boolean detectLoop(){
        if (head==null) return false;
        ListNode fastPtr=head;
        ListNode slowPtr=head;

        while(fastPtr!=null && fastPtr.next!=null){//caso contrario nao poderiamos ir para next.next
            fastPtr=fastPtr.next.next;
            slowPtr =slowPtr.next;//se existir um loop o apontador mais lento vai eventualmente alcancar o mais rapido e o mais rapido nunca tera valor null
            if(fastPtr==slowPtr) return true;
        }
        return false;
    }

    public void createALoopInLinkedList(){//usado para testar funcoes sobre loops
        ListNode one=new ListNode(1);
        ListNode two=new ListNode(2);
        ListNode three=new ListNode(3);
        ListNode four=new ListNode(4);
        ListNode five=new ListNode(5);
        ListNode six=new ListNode(6);

        head=one;
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;
        six.next=three;
    }

    public ListNode startNodeInALoop(){//using floyd's cycle detection algorithm
        if (head==null) return null;
        ListNode fastPtr=head;
        ListNode slowPtr=head;

        while(fastPtr!=null && fastPtr.next!=null){//caso contrario nao poderiamos ir para next.next
            fastPtr=fastPtr.next.next;
            slowPtr =slowPtr.next;//se existir um loop o apontador mais lento vai eventualmente alcancar o mais rapido e o mais rapido nunca tera valor null
            if(fastPtr==slowPtr) return getStartingNode(slowPtr);
        }
        return null;
    }

    public ListNode getStartingNode(ListNode slowptr){
        ListNode temp=head;

        while(temp!=slowptr){
            temp=temp.next;
            slowptr=slowptr.next;
        }
        return temp; //starting node of loop
    }



    public void remove_loop(){
        if (head==null) return ;
        ListNode fastPtr=head;
        ListNode slowPtr=head;

        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr =slowPtr.next;
            if(fastPtr==slowPtr) removeLoopStart(slowPtr);
        }
        return;
    }

    public void removeLoopStart(ListNode node){
        ListNode temp=head;

        while(node.next!=temp.next){
            temp=temp.next;
            node=node.next;//we want to reach node before starting node
        }
        node.next=null;
    }

    public ListNode findNthNodeFromEnd(int pos){
        if (head==null || pos>lengthList()) return null;
        int nova_pos=lengthList()-pos;
        ListNode temp=head;
        while (nova_pos!=0){
            temp=temp.next;
            nova_pos--;
        }
        return temp;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll=new SinglyLinkedList();
        sll.insertNodeBeginning(10);
        sll.insertNode(8);
        sll.insertNode(34);
        sll.insertNode(2);
        sll.insertNode(50);
        sll.insertNode(60);

        SinglyLinkedList sll2=new SinglyLinkedList();
        sll2.createALoopInLinkedList();
        

        System.out.println(sll.findNthNodeFromEnd(7).data);
        sll.printList();
    }
}

