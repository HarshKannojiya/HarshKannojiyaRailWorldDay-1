public class Functions {
//Non-Parameterized Functions
  static void myMethod() {
    System.out.println("I just got executed!");
  }
//Parameterized Functions
static void myMethod1(String fname) {
    System.out.println(fname + " Refsnes");
  }
  public static void main(String[] args) {
//Non-Parameterized Functions calling
    myMethod();
    myMethod();
    myMethod();
//Parameterized Functions calling
myMethod1("Liam");
    myMethod1("Jenny");
    myMethod1("Anja");
  }
}