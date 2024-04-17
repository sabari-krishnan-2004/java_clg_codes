class linkedlist {
     Node head;
     private static int size;

     linkedlist(){
        this.size=0;
     }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;

        }
    }
    // addfirst
    public  void addfirst(String data){
        Node newnode = new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void addlast(String data){
        Node newnode= new Node(data);
        
        if(head==null){
            head = newnode;
            System.out.println(newnode.data+ " inserted");
            return;
        }
        Node currnode = head;
        while(currnode.next !=null){
            currnode = currnode.next;
           
           
        }
         currnode.next=newnode;
    }
    public void addpos(int pos,String data){
        Node newnode = new Node(data);
        if(pos<1||pos>size+1){
            System.out.println("invalid position");
        }
        else if(pos==1){
            newnode.next=head;
            head=newnode;
            
        }
        else{
            Node currnode = head;
            for(int i=1;i<pos-1;i++){
                currnode = currnode.next;
            }
            newnode.next=currnode.next;
            currnode.next=newnode;
            
        }

    }
    public void delfirst(){
        if(head==null){
            System.out.println("the list is empty");
        }
        size--;
        head=head.next;
    }
    public void dellast(){
        if(head==null){
            System.out.println("the list is empty");
        }
        if(head.next==null){
            head=head.next;
            size--;
        }
        Node currnode = head;
        while(currnode.next.next!=null){
            currnode=currnode.next;
        }
        size--;
        currnode.next=null;
    }
    public void delpos(int pos){
        if(head==null){
            System.out.println("the list is empty");
        }
       if(pos<1||pos>size+1){
        System.out.println("please enter a current position");
       }
       else if(pos==1){
        head=head.next;
        size--;
       }
       else{
        Node currnode=head;
        for(int i=1;i<pos-1;i++){
            currnode=currnode.next;
        }
        currnode.next=currnode.next.next;
        size--;
       }
    }
    public void printlist(){
        
        if(head==null){
            System.out.println("the list is empty");
            return;
        }
        Node currnode = head;
        while(currnode!=null){
            System.out.print(currnode.data + "-> ");
            currnode=currnode.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.addfirst("sabari");
        list.addfirst("am");
        list.addfirst("i");
        list.addlast("krishnan");
        list.addpos(5,"boss");
        list.addpos(6,"king");
        //list.delpos(5);
        System.out.println(size);
        list.printlist();
        

    }
}