public class LL<T> implements List<T> {

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
            return next;  //returns the next node
        }
        Node<T> setNext(Node<T> nextval)
        {
            return next = nextval; //assigns into next node
        }
        T getItem()
        {
            return item;  // returns item from a node
        }
        T setItem(T it)
        {
           return item = it; //sets an item in a node
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private Node<T> curr;
    private int cnt;

    /*constructor with no parameters,instantiates the list. curr,tail and head all are same node and all of them point to null*/
    LL() {
        curr = tail = head = new Node<T>(null);
        cnt = 0;
    }

    /*constructor with one parameter. memory chunk is the parameter but the constructor ignores it*/
    LL(int x){
        this();
    }

    /*constructor with two parameters. memory chunk and the user array input are the parameters but the constructor ignores thee memory size
    * and with the parameterless constructor and append function creates a new list*/
    LL (int x,T[] l){
        this();
        for(int i=0;i< l.length;i++)
            append(l[i]);
    }

    @Override
    public void clear() {
        head.setNext(null); // Drop access to links and points to null
        curr = tail = head = new Node<T>(null); //  head,tail and curr all are same node and points to null
        cnt = 0;
    }

    @Override
    public void insert(T it) {
        curr.setNext(new Node<T>(it, curr.next())); // creates a new node and points the node to the next node of present curr and curr points to the newly created node

        /*if the list is empty and we want to insert an item then creates a new node and points the node to the next node of present curr (which is null)
        *and curr points to the newly created node(and this is done by the above line),
        *and the newly created node becomes tail node which is also the next node of curr*/
        if (tail == curr)
            tail = curr.next(); // Or, tail = tail.next (Same operation)
        cnt++;
    }

    @Override
    public void append(T it) {
        tail = tail.setNext(new Node<T>(it, null)); // creates a new node and points the node to null and the current tail points to the newly created node,
        cnt++;                                             //the newly created node becomes the tail node
    }

    @Override
    public T remove() {
        if (curr.next() == null)
            return null;                         // Nothing to remove
        T it = curr.next().getItem();            // Remember the removed value
        if (tail == curr.next()) {
            if(head==curr)                       //if the bar is at the end position or tail node, then curr node is the 2nd last node of the list and points to the tail node.
                tail = curr = head = new Node<T>(null);       //In this case a temp node is created and it traverses through the list from head node to the earlier node of the curr node.
            else {                               //curr node becomes the tail node and temp node becomes the curr node. but this creates a problem when there is only one item in the list
                Node<T> temp = head;             //in that case, head node is the curr node. we can simply make the curr node, the tail node and point them to null (same as clear operation).
                while (temp.next() != curr)
                    temp = temp.next();
                tail = curr;
                curr = temp;
            }
        }                                        // Removed last
        else
            curr.setNext(curr.next().next());    // otherwise we can just point the curr node to the next node of next node of the curr node
        cnt--;                                   // Decrement count
        return it;                               // Return value
    }

    @Override
    public void moveToStart()
    {
        curr = head;
    }

    @Override
    public void moveToEnd()
    {
        Node<T> temp = head;
        while (temp.next() != tail)   //creates a temp node that traverses through the list and at last makes the previous node of the tail node, curr node
            temp = temp.next();
        curr = temp;
    }

    @Override
    public void prev() {
        if (curr == head){
            System.out.println("This operation cannot be executed");
            return; // No previous element
        }
        Node<T> temp = head;
        while (temp.next() != curr)
            temp = temp.next();         //creates a temp node that traverses through the list and at last makes the previous node of the curr node, new curr node
        curr = temp;
    }

    @Override
    public void next()
    {
        if (curr.next() != tail)
            curr = curr.next();         //makes the next node of the curr node, new curr node
        else
            System.out.println("This operation cannot be executed");
    }

    @Override
    public int length() {
        return cnt;                     //list size
    }

    @Override
    public int currPos() {
        Node<T> temp = head;
        int i;
        for (i=0; curr != temp; i++)    //starts from the head node & sequentially reaches the curr node and the number of steps to reach the curr node is the position
            temp = temp.next();
        return i;
    }

    @Override
    public void moveToPos(int pos) {
        if((pos>=0) && (pos<=cnt)){
            curr = head;
            for(int i=0; i<pos; i++)
                curr = curr.next();       //starts from head node and by traversing through the list reaches the desired node and makes that curr node
        }
        else
            System.out.println("Position out of range");
    }

    @Override
    public T getValue() {
        if(curr.next() == null)
            return null;
        return curr.next().getItem();   //returns the item
    }

    @Override
    public int Search(T item){
        Node<T> temp = head;
        int f = -1;
        for(int i=0;i<cnt;i++){
            //System.out.println("In the loop");
            if(temp.next().getItem().equals(item)) {        //creates a temp node starts from the head node
                f = i;                                      //& sequentially reaches the curr node and the number of steps to reach the previous node of the item is the position
                //System.out.println("executed");           //stores the position in "f"
                break;
            }
            else
                temp = temp.next();
        }
        return f;                                           //returns "f"
    }
}
