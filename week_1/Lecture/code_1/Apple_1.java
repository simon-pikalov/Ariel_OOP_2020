interface D {
	int x = 25;
	public void fun();
}
public class Apple_1  implements D, B{

	public static void main(String[] args) {
		Apple_1 apple = new Apple_1();
		boolean d = apple instanceof D;
		System.out.println("d = "+d);
		System.out.println("D.x = " + D.x);
		//D.x = 3; error
		//D obj = new D();  error
		int size = 10;
		D[] arr = new D[size];
		arr[0] = new Apple_1();
		boolean b1 = arr[0] instanceof D;
		boolean b2 = arr[0] instanceof Apple_1;
		boolean b3 = arr[0] instanceof B;
		System.out.println("b1 = "+b1+", b2 = "+b2+", b3 = "+b3);
	}
	@Override
	public void fun() {
		System.out.println("inside fun");
	}
}
