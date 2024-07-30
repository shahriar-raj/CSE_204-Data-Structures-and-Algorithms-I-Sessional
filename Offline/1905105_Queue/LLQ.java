public class LLQ <T> implements Queue<T>{

    private class Node<T> {
        private T item; // Value for this node
        private Node<T> next; // Pointer to next node in list
        // Constructors
        Node(T it, Node<T> nextval)
        {
            item = it; next = nextval;
        }
        Node(Node<T> nextval)
        {
            next = nextval;
        }
        Node<T> next()
        {
            return next;                //returns the next node
        }
        Node<T> setNext(Node<T> nextval)
        {
            return next = nextval;  //assigns into next node
        }
        T getItem()
        {
            return item;                                // returns item from a node
        }
        T setItem(T it)
        {
            return item = it;           //sets an item in a node
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LLQ(){
        front=rear=new Node<>(null);
        size = 0;
    }

    public LLQ(int size){
        this();
    }

    public LLQ(T[] array){
        this();
        for (T t : array) {
            enqueue(t);
        }
    }

    @Override
    public void clear() {
        front=rear=new Node<>(null);
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        rear.setNext(new Node<>(item,null));
        rear=rear.next();
        size++;
    }

    @Override
    public T dequeue() {
//        assert size!=0 : "Queue is empty";
        if(size==0)
            return null;
        T item = front.next().getItem();
        front.setNext(front.next().next());
        if(front.next()==null)
            rear = front;
        size--;
        return item;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T frontValue() {
//        assert size != 0 : "Queue is empty";
        return front.next().getItem();
    }

    @Override
    public T rearValue() {
//        assert size != 0 : "Queue is empty";
        return rear.getItem();
    }

    @Override
    public T leaveQueue() {
//        assert size != 0 : "Queue is empty";
        if(size==0)
            return null;
        Node<T> temp = front;
        T item = rear.getItem();
        while(temp.next()!=rear)
            temp = temp.next();
        temp.setNext(null);
        rear = temp;
        size--;
        return item;
    }
}
