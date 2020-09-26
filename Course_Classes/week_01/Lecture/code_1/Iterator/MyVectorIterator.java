package Iterator;

import java.util.Iterator;

public class MyVectorIterator {
	private int size;
	private final int INIT_SIZE = 10;
	private Object [] data;
	////////// iterator
	public MyIterator iterator(){
		return new MyIterator();
	}

	@SuppressWarnings("unchecked")
	public MyVectorIterator(){
		size = 0;
		data = new Object[INIT_SIZE];
	}
	public void add(Object value){
		if (size == data.length) resize();
		data[size++] = value;
	}
	@SuppressWarnings("unchecked")
	private void resize(){
		Object [] temp = new Object[data.length+INIT_SIZE];
		for (int i = 0; i<data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	public int size(){return size;}

	public int capacity(){return data.length;}

	public String toString(){
		String s = "[";
		for (int i = 0; i<size; i++){
			s = s + data[i] + ", ";
		}
		s  = s + "]";
		return s;
	}
	/////////////// MyIterator
	private class MyIterator implements Iterator<Object>{
		int itCount = 0;
		public MyIterator(){
			itCount = 0;
		}
		@Override
		public boolean hasNext() {
			return itCount < size;
		}

		@Override
		public Object next() {
			return data[itCount++];
		}
		@Override
		public void remove() {
			//  Iterator removes the last element returned by the iterator
			if (itCount > 0){
				for (int i=itCount-1; i<size-1; i++){
					data[i] = data[i+1];
				}
				itCount--;
				size--;
			}
		}
	}
}
