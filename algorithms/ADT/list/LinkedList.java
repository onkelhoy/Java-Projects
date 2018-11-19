public class LinkedList<T> implements List<T> {
    private Node start;
    private Node end;
    private int length = 0;
    
    @Override
    public void add (T element) {
        if (start == null) {
            start = new Node(element);
        }
        else {
            Node tmp = new Node(element);
            if (end == null) {
                end = tmp;
                start.next = end;
            } else {
                end.next = tmp;
                end = tmp;
            }
        }

        length++;
    }

    private Node getParent (int index) {
        if (index < length || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        Node tmp = start;
        for (int i=0; i<index-1; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
    @Override
    public T get (int index) {
        Node tmp = getParent(index);
        if (tmp.next == null) {
            return (T)tmp.element;
        }
        return (T)tmp.element;
    }
    @Override
    public int size () {
        return length;
    }

    @Override
    public void remove (T element) {
        if (length == 0) {
            throw new NullPointerException();
        }
        Node tmp = start;
        if (tmp.element.equals(element)) {
            start = start.next;
        } else {
            while (tmp.next != null && !tmp.next.element.equals(element)) {
                tmp = tmp.next;
            }
            // tmp is parent, tmp.next is target 
            if (tmp.next.element.equals(end.element)) {
                end = tmp;
            } else {
                tmp.next = tmp.next.next;
            }
        }

        length--;
    }
    @Override
    public void removeAt (int index) {
        Node tmp = getParent(index);
        if (index == 0) {
            start = start.next;
        } else {
            tmp.next = tmp.next.next;
        }

        length--;
    }

    @Override
    public String toString () {
        Node tmp = start;
        StringBuilder strb = new StringBuilder();
        strb.append("[");
        if (tmp != null) {
            strb.append(tmp.element);
            while ((tmp = tmp.next) != null) {
                strb.append(","+tmp.element);
            }
        }
        strb.append("]");
        return strb.toString();
    }


    private class Node<T> {
        public T element;
        public Node next;

        public Node (T element) {
            this.element = element;
        }
    }
}