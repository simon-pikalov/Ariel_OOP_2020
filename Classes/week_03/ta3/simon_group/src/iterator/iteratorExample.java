package iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
//with help of exampels from this site
//http://tutorials.jenkov.com/java-collections/iterable.html


public class iteratorExample {

    static void printIterator(List<String> list ){

        System.out.println("\n*******Iterator*******\n");
        Iterator<String> iterator = list.iterator();
        System.out.println(iterator);
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println( element );
        }
    }


    static void printJavaFor(List<String> list ){
        System.out.println("\n*******java for :*******\n");
        for( String element : list ){
            System.out.println( element.toString() );
        }
    }



    static void printForEach(List<String> list ){
        System.out.println("\n*******ForEach*******\n");
        list.forEach( (element) -> System.out.println(element+"!"));
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList <String>();


        list.add("first");
        list.add("second");
        list.add("third");
        list.add("last");

        printIterator(list);
        printJavaFor(list);
        printForEach(list);

    }

}
