public class BST {
    private class Node<T> {
        private T item; // Value for this node
        private Node<T> left; // Pointer to left node
        private Node<T> right; // Pointer to right node
        // Constructors
        Node(T it, Node<T> leftval, Node<T> rightval)
        {
            item = it;
            left = leftval;
            right = rightval;
        }
        Node(Node<T> leftval, Node<T> rightval)
        {
            left = leftval;
            right = rightval;
        }

        Node<T> left()
        {
            return left;                //returns the left node
        }
        Node<T> right()
        {
            return right;                //returns the right node
        }
        Node<T> setLeft(Node<T> leftval)
        {
            return left = leftval;  //assigns into left node
        }
        Node<T> setRight(Node<T> rightval)
        {
            return right = rightval;  //assigns into right node
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


    private Node<Integer> root = new Node<>(null,null,null);
    private int count = 0,l=0;

    private void Print_tree(Node<Integer> bstnode){
        if(bstnode == null||bstnode.getItem()==null){
            return;
        }
        System.out.print(bstnode.getItem());
        if(bstnode.left()!=null||bstnode.right()!=null){
            System.out.print("(");
            if(bstnode.left()!=null)
                Print_tree(bstnode.left());
            System.out.print(")(");
            if(bstnode.right()!=null)
                Print_tree(bstnode.right());
            System.out.print(")");
        }
    }

    public void Print(){
        Print_tree(root);
        System.out.println();
//        System.out.println(count);
    }

    private int[] Inorder(Node<Integer> bst, int[] p){
        if(bst.left()!=null)
            Inorder(bst.left(),p);
        if(bst.getItem()!=null){
            p[l++] = bst.getItem();
//            System.out.println(bst.getItem());
        }
        if(bst.right()!=null)
            Inorder(bst.right(),p);
        return p;
    }

    private int[] Preorder(Node<Integer> bst, int[] p){
        if(bst.getItem()!=null){
            p[l++] = bst.getItem();
//            System.out.println(bst.getItem());
        }
        if(bst.left()!=null)
            Preorder(bst.left(),p);
        if(bst.right()!=null)
            Preorder(bst.right(),p);
        return p;
    }

    private int[] Postorder(Node<Integer> bst, int[] p){
        if(bst.left()!=null)
            Postorder(bst.left(),p);
        if(bst.right()!=null)
            Postorder(bst.right(),p);
        if(bst.getItem()!=null){
            p[l++] = bst.getItem();
//            System.out.println(bst.getItem());
        }
        return p;
    }

    public void Insert(int item){
        Node<Integer> temp = root;
        while(true) {
            if(temp.getItem()==null) {
                temp.setItem(item);
                count++;
//                System.out.println("Done");
                break;
            }
            if (item < temp.getItem()) {
//                System.out.println(temp.getItem() +" "+ item);
//                System.out.println("Left");
                if(temp.left() == null)
                    temp.setLeft(new Node<>(null,null,null));
                temp = temp.left();
            }
            else {
//                System.out.println(temp.getItem() +" "+ item);
//                System.out.println("Right");
                if(temp.right() == null)
                    temp.setRight(new Node<>(null,null,null));
                temp = temp.right();
            }
        }
    }

    public boolean Find(int item) {
        Node<Integer> temp = root;
        while (temp != null && root.getItem()!=null) {
            if (temp.getItem() == item)
                return true;
            if (item < temp.getItem())
                temp = temp.left();
            else
                temp = temp.right();
        }
        return false;
    }

    public boolean Delete(int item){
        if (!this.Find(item))
            return false;
        Node<Integer> temp = root;
        Node<Integer> temp_prev = null;

        while (temp.getItem() != item) {
            if (item < temp.getItem()) {
                temp_prev = temp;
                temp = temp.left();
            } else {
                temp_prev = temp;
                temp = temp.right();
            }
        }

        if(temp.left()==null&&temp.right()==null){
            if(temp == root) {
                root = new Node<>(null,null,null);
                count--;
                return true;
            }
            if(temp_prev.left()==temp)
                temp_prev.setLeft(null);
            else
                temp_prev.setRight(null);
            count--;
            return  true;
        }

        if(temp.left()==null){
            if(temp == root) {
                root = root.right();
                count--;
                return true;
            }
            if(temp_prev.left()==temp)
                temp_prev.setLeft(temp.right());
            else
                temp_prev.setRight(temp.right());
            count--;
            return  true;
        }
        if(temp.right()==null){
            if(temp == root) {
                root = root.left();
                count--;
                return true;
            }
            if (temp_prev.left() == temp)
                temp_prev.setLeft(temp.left());
            else
                temp_prev.setRight(temp.left());
            count--;
            return  true;
        }

        Node<Integer> temp_prev2 = temp;
        temp_prev = temp.left();
        if(temp_prev.right()==null){
            temp.setItem(temp_prev.getItem());
            temp_prev2.setLeft(temp_prev.left());
            count--;
            return true;
        }
        while(temp_prev.right()!=null){
            temp_prev2 = temp_prev;
            temp_prev = temp_prev.right();
        }
        temp.setItem(temp_prev.getItem());
        temp_prev2.setRight(temp_prev.left());
        count--;
        return true;
    }

    public int[] Traversal(String s){
        int[] p = new int[count];
        l = 0;
        if(s.equalsIgnoreCase("In"))
            Inorder(root,p);
        else if(s.equalsIgnoreCase("Pre"))
            Preorder(root,p);
        else if(s.equalsIgnoreCase("Post"))
            Postorder(root,p);
        else
            System.out.println("No traversal with the specified name");
        return p;
    }
}
