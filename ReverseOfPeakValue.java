public class ReverseOfPeakValue {

	public static void main(String[] args) {
		
		int[] arr = {10,20,25,15,20};
		for(int i = 1;i<arr.length-1;i++) {
			if(arr[i]<arr[i-1] && arr[i]<arr[i+1]) {
				System.out.println(arr[i]);
			}
		}
	}
}