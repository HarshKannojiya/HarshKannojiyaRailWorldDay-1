import java.util.Arrays;

class Sorting0And1And2Question{

	public static void main(String[] args){

		int[] arr = {0,0,0,1,2,2,1};
		int count2 = 0;
		int count0 = 0;
		int count1=0;
		for(int i = 0;i<arr.length-1;i++) {
			if(arr[i]==2) {
				count2++;
			}
			else if(arr[i]==0) {
				count0++;
			}
			else {
				count1++;
			}
			
		}
		System.out.println(count0);
		for(int i = 0;i<arr.length;i++) {
			if(i<count2) {
				arr[i]=2;
			}
			else if(i<count0+count2) {
				arr[i]=0;
			}
			else {
				arr[i]=1;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
