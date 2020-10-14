package Iterator;

import java.util.Iterator;

public class TestMyIterator {

	public static void main(String[] args) {
		MyVectorIterator vect = new MyVectorIterator();
		vect.add("a");
		vect.add("b");
		vect.add("c");
		vect.add("d");
		Iterator<Object> it = vect.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
