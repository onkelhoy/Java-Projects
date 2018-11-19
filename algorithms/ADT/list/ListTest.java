public class ListTest implements Test {

    @Override
    public void Run() {
        ArrayList alist = new ArrayList<Integer>();
        LinkedList llist = new LinkedList<Integer>();
        DoubleLinkedList dlist = new DoubleLinkedList<Integer>();
        for (int i=0; i<22; i++) {
            alist.add(i);
            llist.add(i);
        }

        System.out.println("Array List:");
        System.out.println(alist.toString());
        alist.remove(6);
        System.out.println(alist.toString());
        alist.removeAt(0);
        System.out.println(alist.toString());

        System.out.println("\nLinked List:");
        System.out.println(llist.toString());
        llist.remove(6);
        System.out.println(llist.toString());
        llist.removeAt(0);
        System.out.println(llist.toString());

        dlist.add(5);
    }
}