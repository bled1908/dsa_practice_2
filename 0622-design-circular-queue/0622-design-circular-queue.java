 class Node{
    int val;
    Node next ; 
    Node(int val){
        this.val = val;
    }
     Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}
class MyCircularQueue {
    private Node head , tail;
    private final int cap;
    private int size;
    public MyCircularQueue(int k) {
        this.head = null;
        this.tail = null;
        this.cap = k;
        this.size = 0;
    }
    
    public boolean enQueue(int val) {
        if(size == cap)return false; // check overflow
        if(head == null){ 
            head = tail = new Node(val);
        }else{
            tail.next = new Node(val);
            tail = tail.next;
        }
        tail.next = head;
        size++;
        return true;
    }
    
    public boolean deQueue() {
       if(head == null)return false;
       if(head.next == head){
        head = tail = null;
       }else{
        head = head.next;
        tail.next = head;
       }
       size--;
       return true;
    }
    
    public int Front() {
        if(head == null)return -1; // underflow case
        return head.val;
    }
    
    public int Rear() {
        if(head == null)return -1;// underflow case
        return tail.val;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public boolean isFull() {
        return size == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */