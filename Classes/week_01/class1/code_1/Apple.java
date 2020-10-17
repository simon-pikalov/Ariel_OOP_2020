public class Apple  implements B, C{
	public static void main(String[] args) {
		Apple apple = new Apple();
		boolean a = apple instanceof A;
		System.out.println("a = "+a);
		boolean b = apple instanceof B;
		System.out.println("b = "+b);
		boolean c = apple instanceof C;
		System.out.println("c = "+c);
		apple.doSomeThingA();
		apple.doSomeThingC();
	}
}
interface A {
	public default void doSomeThingA() {
        System.out.println("inside A");
    }}
interface B {}
interface C extends A {
	public default void doSomeThingC() {
        System.out.println("inside C");
    }}

