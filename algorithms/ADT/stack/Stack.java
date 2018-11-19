class Stack<T> implements StackInterface<T> {
    private DoubleLinkedList list;
    public Stack () {
        list = new DoubleLinkedList<T>();
    }

    @Override
    public void push(T element) {
        list.add(element);
    }
    @Override
    public T peek() {
        return list.getLast();
    }
    @Override
    public T pop() {
        T elm = list.getLast();
        list.RemoveLast();
        return elm;
    }
}