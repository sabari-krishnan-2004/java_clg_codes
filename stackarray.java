public class stackarray{
    int top;
    int capacity;
    int[] arr;
    stackarray(){
        top=-1;
        capacity=10;
        arr=new int[capacity];
    }
    public boolean isempty(){
        return top==-1;
    }
    public boolean isfull(){
        return top==capacity-1;
    }
    public void push(int data){
        if(top==capacity-1){
            System.out.println("stack is full");
        }
        else{
        top++;
        arr[top]=data;
        }
    }
    public int pop(){
        return arr[top--];
    }
    
    
    public static void main(String[]args){
        stackarray stack = new stackarray();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
       
       
    }
}

