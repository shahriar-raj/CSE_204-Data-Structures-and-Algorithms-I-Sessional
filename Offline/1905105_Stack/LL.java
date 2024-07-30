public class LL <T> implements Stack<T>{

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

    private Node<T> top;
    private int size;

    public LL(){
        top = null;
        size = 0;
    }

    public LL(int x){
        this();
    }

    public LL(T[] l, int x){
        this();
        for(int i =0; i<l.length ; i++) {
            push(l[i]);
        }
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public void push(T item) {
        Node temp = new Node(item,null);
        temp.setNext(top);
        top = temp;
        size++;
    }

    @Override
    public T pop() {
        if(size==0)
            return null;
        T item = top.getItem();
        top = top.next();
        size--;
        return item;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T topValue() {
        if(size==0)
            return null;
        return top.getItem();
    }

    public void setDirection(int i) {

    }
}
