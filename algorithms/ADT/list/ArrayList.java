public class ArrayList<T> implements List<T> {
    private T[] array;
    private int _size = 0;
    public ArrayList () {
        array = (T[])new Object[10];
    }

    @Override
    public T get (int index) {

        return null;
    }
    @Override
    public int size () {
        return _size;
    }

    @Override
    public void add (T element) {
        if (_size == array.length) {
            resize();
        }

        array[_size++] = element;
    }
    @Override
    public void remove (T element) {
        int index = -1;
        for (int i=0; i<_size; i++) {
            if (index != -1) {
                array[i - 1] = array[i]; 
            }
            else if (element.equals(array[i])) {
                index = i;
                _size--;
            }
        }

        if (index == -1) {
            throw new NullPointerException();
        }
    }
    @Override
    public void removeAt (int index) {
        if (index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index + 1; i < _size; i++) {
            array[i - 1] = array[i];
        }
        _size--;
    }

    @Override
    public String toString () {
        StringBuilder strb = new StringBuilder();
        strb.append("[");
        for (int i=0; i<_size-1; i++) {
            strb.append(array[i]);
            strb.append(",");
        }
        strb.append(array[_size-1] + "]");
        return strb.toString();
    }

    private void resize () {
        T[] temp = (T[])new Object[_size * 2];
        int next = 0;
        for (T elm : array) {
            temp[next++] = elm;
        }

        array = temp;
    }
}