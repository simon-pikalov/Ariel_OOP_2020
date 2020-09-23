
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleIterator {

	
	public static void main(String[] args) {
		ArrayList<Character> aList = new ArrayList<>();
		aList.add('a');
		aList.add('b');
		aList.add('c');
		aList.add('d');
		Iterator<Character> aIter = aList.iterator();
		while(aIter.hasNext()){
			System.out.print(aIter.next() + ", ");
		}
		System.out.println();
		LinkedList<String> linkList = new LinkedList<>();
		linkList.add("x");
		linkList.add("y");
		linkList.add("z");
		linkList.add("w");
		Iterator<String> linkIter = linkList.iterator();
		while(linkIter.hasNext()){
			System.out.print(linkIter.next() + ", ");
		}
		System.out.println();
	}

}
