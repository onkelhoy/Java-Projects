class DoubleLinkedList<T> implements List<T> {
    private int size = 0;
    private Node first;
    private Node last;

    public DoubleLinkedList () {
        
    }

    @Override
    public void remove(T element) {
        
    }
    @Override
    public void removeAt(int index) {
        
    }
    @Override
    public T get(int index) {
        if (index < size || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node tmp = first;
        for (int i=0; i<index-1; i++) {
            tmp = tmp.child;
        }
        return (T)tmp.element;
    }
    @Override
    public void add(T element) {
        if (first == null) {
            first = new Node(element, null);
            last = first;
        } else {
            last = new Node(element, last);
        }

        size++;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public int size() {
        return this.size;
    }
    public void RemoveLast () {
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.parent;
            last.child = null;
        }
        size--;
    }
    public T getLast () {
        return (T)last.element;
    }

    private class Node<T> {
        public Node child = null;
        public Node parent = null;
        public T element;

        public Node (T element, Node parent) {
            this.element = element;
            this.parent = parent;
            if (parent != null) {
                parent.child = this;
            }
        }
    }
}