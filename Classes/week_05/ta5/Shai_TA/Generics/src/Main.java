import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> void objDetail(T o1) {
        System.out.println(o1.toString());
        System.out.println("Class:\t" + o1.getClass());
    }

    public static <T> void printArray(T[] array) {
        System.out.println("Say hello to my little Array!");
        for (T t : array) {
            System.out.println("\t" + t);
        }
    }

    public static <T extends Number> void printArray(T[] array) {
        System.out.println("Say hello to my little (Number) Array!");
        for (T t : array) {
            System.out.println("\t" + t);
        }
    }

    public static <T extends Comparable<T>> T Max(T o1, T o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        }
        return o2;
    }

    public static void main(String[] args) {
        // Generic Function
        Double d_obj = 42d;
        objDetail(d_obj);

        // Generic Arrays
        String[] str_array = {"34", "ser", "wer"};
        printArray(str_array);


        // Generic Extends
        System.out.println(Max("String1", "String2")); // String Example
        System.out.println(Max(4f, 3.2f)); // Float Example

        Double[] d_array = {234.5, 2534.234, 235.32};
        printArray(d_array);

        // Generic class
        GenArray<String> a_str = new GenArray<>();
        a_str.add("One");
        a_str.add("Two");
        a_str.add("Three");

        for (int i = 0; i < a_str.size(); ++i) {
            System.out.println(a_str.get(i));
        }

        System.out.println("\nGeneric Class Function");
        System.out.println(a_str.sillyAdd(1, "Four"));
        System.out.println();
    }
}