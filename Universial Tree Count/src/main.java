import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        BinarySearchTree T = new BinarySearchTree(14);
        T.insert(10);
        T.insert(15);
        T.insert(15);
        T.insert(15);
        T.insert(15);
        T.insert(15);
        T.insert(15);
        T.insert(15);
        T.insert(8);
        T.insert(8);
        T.insert(8);
        T.insert(12);
        T.insert(12);
        T.insert(12);
        T.insert(11);
        T.insert(11);

        HashMap<Integer, Integer> M = UTC(T);

        for (Integer name: M.keySet()){

            String key =name.toString();
            String value = M.get(name).toString();  
            System.out.println(key + " " + value);  
        } 
    }

    public static void preorderTraversal (Node N) {
        if (N.left != null) { preorderTraversal(N.left); }
        if (N.right != null) { preorderTraversal(N.right); }
        
        System.out.println(N.value);
    } 

    public static HashMap<Integer, Integer> UTC (BinarySearchTree T) {
        HashMap<Integer, Integer> M = new HashMap<Integer, Integer>();
        preorder(T.root, M);

        return M;
    }
    public static boolean preorder (Node N, HashMap M) {
        boolean left = true;
        boolean right = true;
        if (N.left != null) { left = preorder(N.left, M); }
        if (N.right != null) { right = preorder(N.right, M); }

        if ((N.left == null || left && N.left.value == N.value ) 
            && (N.right == null || right && N.right.value == N.value )) {
            increase(M, N);
            return true;
        }
        return false;
    }
    public static void increase (HashMap M, Node N) {
        int count = 1; // initial value
        if (M.containsKey(N.value)) { // if already exist increase by 1
            count = (int)M.get(N.value);
            count++;
        } 

        M.put(N.value, count); // override?
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node (int value) {
        this.value = value; 
    }

    public void add (Node c) {
        // this breaks the BST structure.. but for the UTC to work.. *
        if (right == null && c.value == value) { right = c; }
        else if (left == null && c.value == value) { left = c; } //  * until here 
        else if (c.value > value) {
            if (right == null) { right = c; }
            else { right.add(c); }
        } else {
            if (left == null) { left = c; }
            else { left.add(c); }
        }
    }
}

class BinarySearchTree {
    public Node root;
    public BinarySearchTree (int startvalue) {
        root = new Node(startvalue);
    }

    public void insert (int value) {
        Node c = new Node(value);
        root.add(c);
    }
}