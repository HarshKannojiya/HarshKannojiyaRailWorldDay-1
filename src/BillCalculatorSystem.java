package src;

public class BillCalculatorSystem {

	public static void main(String[] args) {
	int unit = 210;
	int BillRupees = unit<=100?
			unit*2:(unit>=100 && unit<=150?
			(unit-100)*3+(100*2):(unit>=151 && unit<=200?
			(unit-150)*4+(50*3)+(100*2):(unit>=201 && unit<=250?
			(unit-200)*5+(50*4)+(50*3)+(100*2):(unit>=251 && unit<=300?
			(unit-250)*6+((50*5)+(50*4)+(50*3+(100*2))):(unit>=301 && unit<=500?
			(unit-300)*7+((50*6)+(50*5)+(50*4)+(50*3)+(100*2)):(unit-200)*8+(50*7)+(50*6)+(50*5)+(50*4)+(50*3)+(50*2))))));
	System.out.println(BillRupees);
	}
}