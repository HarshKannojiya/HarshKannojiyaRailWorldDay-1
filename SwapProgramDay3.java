public class SwapPorgramDay3 {

	public static void main(String[] args) throws Exception {
		//swap two variables without using third variable
		int a = 10,b = 20;
		a=a+b;
		b=a-b;
		a= a-b;
		
		System.out.println(a+" "+b);
		//swap two variables without using arithmatic expression
		int c= b;
		b = a;
		a = c;
		System.out.println(a+" "+b);
		
		
	}

}
