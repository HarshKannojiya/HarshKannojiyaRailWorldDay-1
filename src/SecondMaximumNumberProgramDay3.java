import java.util.Scanner;

class SecondMaximumNumberProgramDay3{
	public static void main(String[] args) throws Exception {


		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int [] arr = new int[s];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}

		int max = Integer.MAX_VALUE;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		int secmax = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]==max) {
				continue;
			}
			else if(arr[i]>secmax) {
				secmax = arr[i];
			}
		}
		
		System.out.println(secmax);
		
	}

}