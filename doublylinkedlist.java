public class doublylinkedlist {
    Node head;
    Node tail;
    static int size;

    doublylinkedlist() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null; 
            this.prev = null;
            size++;
        }
    }

    public void addfirst(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            tail = newnode;
        } else {
            head.prev = newnode;
        }
        newnode.next = head;
        head = newnode;
    }

    public void addlast(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;

        }
        tail = newnode;
    }

    /**
     * @param pos
     * @param data
     */
    public void addpos(int pos, String data) {
        Node newnode = new Node(data);
        if (pos < 1 || pos > size + 1) {
            System.out.println("please enter a current position");
        } else if (pos == 1) {

            newnode.next = head;
            head.prev = newnode;
            head = newnode;

        } else if (pos == size ) {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        } 
        else {
            Node currnode = head;

            for (int i = 1; i < pos - 1; i++) {
                currnode = currnode.next;
            }
            Node currnode2 = currnode.next;
            currnode.next = newnode;
            currnode2.prev = newnode;
            newnode.prev = currnode;
            newnode.next = currnode2;
        }

    }

    public void printforward() {
        if (head == null) {
            System.out.println("the list is empty");
        }
        Node currnode = head;
        while (currnode != null) {
            System.out.print(currnode.data + " ->");
            currnode = currnode.next;
        }
        System.out.println("null");
    }

    public void printrev() {
        if (head == null) {
            System.out.println("the list is empty");
        }
        Node currnode = tail;
        while (currnode != null) {
            System.out.print(currnode.data + " ->");
            currnode = currnode.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        doublylinkedlist list = new doublylinkedlist();
        list.addfirst("sabari");
        list.addfirst("am");
        list.addfirst("i");
        list.addlast("krishnan");
        System.out.println(size);
        list.addpos(5, "heloo");
        list.printforward();
        list.printrev();

    }
}
