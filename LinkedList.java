public class LinkedList {
    public static class LL{
        private Node head;
        private Node tail;

        private int size;

        public LL(){
            this.size=0;
        }

        private class Node{
            private int value;
            private Node next;

            public Node(int value){
                this.value=value;
            }
            public Node(int value, Node next){
                this.value=value;
                this.next=next;
            }
        }
        public void InsertFirst(int value){
            Node node=new Node(value);
            node.next=head;
            head=node;

            if(tail==null){
                tail=head;

            }
            size++;
        }
        public void InsertLast(int value){
            if (tail==null){
                InsertFirst(value);
                return;
            }
            Node node=new Node(value);

            tail.next=node;
            tail=node;
            size++;
        }
        public void Display(){
            Node temp=head;
            while (temp!=null){
                System.out.print(temp.value+"->");
                temp=temp.next;

            }
            System.out.println("end");
        }
        public void Insert(int value, int index){
            if(index==0){
                InsertFirst(value);
            }
            if(index==size){
                InsertLast(value);
            }
            Node temp=head;
            for (int i = 1; i <index ; i++) {
                temp=temp.next;
            }
            Node node=new Node(value, temp.next);
            temp.next=node;
            size++;
        }
        public int DeleteFirst(){
            int value=head.value;
            head=head.next;
            if (head==null){
                tail=null;
            }
            size--;
            return value;
        }
        public void reverse(){
            if (head== null || head.next == null){
                return;
            }
            Node prevnode=head;
            Node curnode=head.next;
            while (curnode!=null){
                Node nextnode=curnode.next;
                curnode.next=prevnode;
                prevnode=curnode;
                curnode=nextnode;

            }
            head.next=null;
            head=prevnode;
        }
    }

    public static void main(String[] args) {
        LL list= new LL();
        list.InsertFirst(2);
        list.InsertFirst(4);
        list.InsertFirst(5);
        list.InsertFirst(7);
        list.InsertLast(1);
        list.Insert(8,2);
        list.Display();
        System.out.println(list.DeleteFirst());
        list.Display();
        list.reverse();
        list.Display();



    }
}
