public class qeuey {
    static class qeue{
        static int arr[];
        static int size;
        static int rear=-1;
        qeue(int n){
            arr = new int[n];
            this.size=n;

        }
        public qeue() {
        }
        public static boolean isempty(){
            return rear==-1;
        }
        public static void enque(int data){
            if(rear==size-1){
                System.out.println("full queue");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        public int dequeue(){
            if(isempty()){
                System.out.println("empty queue");
                return -1;
            }
            int front=arr[0];
            for (int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;

        }
        public int peek(){
            if(isempty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }
        public static void main(String[]args){
            qeue q= new qeue(5);
            q.enque(1);
            q.enque(2);
            q.enque(3);
            while(!q.isempty()){
                System.out.println(q.peek());
                q.dequeue(); 
            }
        }
    }
    
}
