
public class TestEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[] {11,1,2,3,4,5,6,7,8,9};
		int n=6;
		n=arr[arr[n]/2];                //n=arr[arr[6]/2]; Here., just only index div 
		                                //n =arr[Index[6]/2] it means half of index 6/2=3 Now.,
		                                // n=arr[3];    Now n re-assign to 2.,arr[3] value is 2 in array
		System.out.println(arr[n]/2);   // arr[2]/2    2/2=1
        System.out.println(arr[3]);
		
       
       
       
	}

}
