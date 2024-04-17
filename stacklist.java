public class stacklist {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class stack{
        public static Node head;
        static boolean isempty(){
            return head==null;
        }
        public static void push(int data){
            Node newnode = new Node(data);
            if(isempty()){
                head=newnode;
                return;
            }
            else{
                newnode.next=head;
                head=newnode;
            }
        }
        public static int pop(){
            int top = head.data;
            head=head.next;
            return top;
        
        }
        public static int peek(){
            if(isempty()){
                return -1;
            }
            int top =head.data;
            return top;

        }
        public static void display(){
           Node currnode=head;
           while(currnode!=null){
            System.out.print(currnode.data+" ");
            currnode=currnode.next;
           }
           System.out.println();

        }
        public static void main(String args[]){
            stack s = new stack();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.pop();
            s.display();
            System.out.println(s.peek());
            
        }
    }
}
