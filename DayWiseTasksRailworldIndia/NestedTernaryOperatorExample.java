// Example For Nested Ternary Operator
// Program to find largest of three numbers using nested ternary operator
class NestedTernaryOperatorExample{
	public static void main(String[] args) {
    
    int n1 = 2, n2 = 9, n3 = -11;

    int largest = (n1 >= n2) ? ((n1 >= n3) ? n1 : n3) : ((n2 >= n3) ? n2 : n3);
    System.out.println("Largest Number: " + largest);
  }
	
}