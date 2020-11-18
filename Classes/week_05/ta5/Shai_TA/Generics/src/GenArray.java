public class GenArray<T> {

    private int _top = 0;
    private int _max = 10;
    private Object[] _array;

    GenArray() {
        _array = new Object[_max];
    }

    /**
     * Adds an object to the array,
     * if the array has reached it's maximum
     * more space is allocated.
     * @param new_obj The new object to add.
     */
    public void add(T new_obj) {
        if (_top == _max) { // Checks if the array has reached its capacity
            _max += 10;
            String[] tmp_str_arr = new String[_max];
            System.arraycopy(_array, 0, tmp_str_arr, 0, _array.length);
            _array = tmp_str_arr;
        }
        _array[_top++] = new_obj;
    }

    public T get(int i) {
        return (T) _array[i];
    }

    /**
     * This is a silly functions, that concatenates the string of the element in the
     * i'th place with the string of the given parameter
     * @param i The index of the element in the array
     * @param obj The object
     * @return The two strings attached
     */
    public T sillyAdd(int i, T obj) {
        return (T) (_array[i].toString() + obj.toString());
    }

    /**
     * Returns the size of the string array
     * @return size of the string array
     */
    public int size() {
        return _top;
    }
}
