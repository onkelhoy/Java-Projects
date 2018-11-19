public interface List<T> {
    public T get (int index);
    public int size ();
    public String toString ();

    public void add (T element);
    public void remove (T element);
    public void removeAt (int index);
}