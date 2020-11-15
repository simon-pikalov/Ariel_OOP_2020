import java.util.Iterator;

public class NiceStringCollection {
    private String[] _string_arr;
    private int _top = 0;
    private int _max = 10;

    NiceStringCollection() {
        _string_arr = new String[_max];
    }

    /**
     * Adds a string to the string array,
     * if the array has reached it's maximum
     * more space is allocated.
     * @param n_str The new string to add.
     */
    public void add(String n_str) {
        if (_top == _max) { // Checks if the array has reached its capacity
            _max += 10;
            String[] tmp_str_arr = new String[_max];
            System.arraycopy(_string_arr, 0, tmp_str_arr, 0, _string_arr.length);
            _string_arr = tmp_str_arr;
        }
        _string_arr[_top] = n_str;
        ++_top;
    }

    /**
     * Returns the size of the string array
     * @return size of the string array
     */
    public int size(){
        return _top;
    }

    /**
     * Gets the string from tha array at a specific index.
     * @param idx The index
     * @return The string at the index location
     */
    public String get(int idx) {
        return _string_arr[idx];
    }

    /**
     * Class iterator
     * @return NiceStringCollection iterator
     */
    public NiceIterator iterator(){
        return new NiceIterator();
    }

    public class NiceIterator implements Iterable<String> {

        private String[] arrayList;
        private int currentSize;

        public NiceIterator() {
            this.arrayList = _string_arr;
            this.currentSize = _top;
        }

        @Override
        public Iterator<String> iterator() {
            Iterator<String> it = new Iterator<String>() {

                private int currentIndex = 0;

                @Override
                public boolean hasNext() {
                    return currentIndex < currentSize && arrayList[currentIndex] != null;
                }

                @Override
                public String next() {
                    return arrayList[currentIndex++];
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }
    }
}
