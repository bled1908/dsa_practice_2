class MyLinkedList {
    private class Node {
        int value;
        Node next,prev;
        Node(int value) {
            this.value = value;
        }
    }

    private Node head,tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head= new Node(0);
        tail= new Node(0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index>size)return;
        if(index<0)index=0;
        Node pred=head;
        for(int i=0;i<index;i++)pred=pred.next;
        Node succ=pred.next;
        Node newNode=new Node(val);
        newNode.prev=pred;
        pred.next=newNode;
        newNode.next=succ;
        succ.prev=newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        Node pred=head;
        for(int i=0;i<index;i++)pred=pred.next;
        Node toDelete=pred.next;
        Node succ=toDelete.next;
        pred.next=succ;
        succ.prev=pred;

        size--;
    }
}