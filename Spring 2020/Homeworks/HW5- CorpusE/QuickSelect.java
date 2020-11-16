public class QuickSelect {
	public static int partition (int[] arr, int left, int right) 
	{ 
		int pivot = arr[right], pivotloc = left; 
		for (int i = left; i <= right; i++) 
		{ 
			// inserting elements of less value  to the left of the pivot location 
			if(arr[i] < pivot) 
			{ 
				int temp = arr[i]; 
				arr[i] = arr[pivotloc]; 
				arr[pivotloc] = temp; 
				pivotloc++; 
			} 
		} 

		// swapping pivot to the final pivot location 
		int temp = arr[right]; 
		arr[right] = arr[pivotloc]; 
		arr[pivotloc] = temp; 

		return pivotloc; 
	} 
 
	public static int kthLargest(int[] arr, int left, int right, int k) 
	{ 
		// find the partition 
		int partition = partition(arr,left,right); 

		// if partition value is equal to the kth position, 
		// return value at k. 
		if(partition == k) 
			return arr[partition];	 

		// if partition value is less than kth position, 
		// search right side of the array. 
		else if(partition < k ) 
			return kthLargest(arr, partition + 1, right, k ); 

		// if partition value is more than kth position, 
		// search left side of the array. 
		else
			return kthLargest(arr, left, partition-1, k );		 
	} 

	public static void main(String[] args) 
	{ 
		int[] array = new int[]{30, 20, 50, 70, 80, 60, 10, 40, 90, 15, 55, 25, 85, 65, 35};  
		int length = array.length;
		
		int kPosition = 1; 
		System.out.println("15th largest element in array : " + kthLargest(array, 0, length - 1, kPosition - 1)); 
		
		kPosition = 3; 
		System.out.println("13th largest element in array : " + kthLargest(array, 0, length - 1, kPosition - 1));
		
		kPosition = 5;
		System.out.println("10th largest element in array : " + kthLargest(array, 0, length - 1, kPosition - 1));
		
		kPosition = 10; 
		System.out.println("5th largest element in array : " + kthLargest(array, 0, length - 1, kPosition - 1));
		
		kPosition = 13; 
		System.out.println("3rd largest element in array : " + kthLargest(array, 0, length - 1, kPosition - 1)); 
		
		kPosition = 15; 
		System.out.println("1st largest element in array : " + kthLargest(array, 0, length - 1, kPosition - 1)); 

		kPosition=array.length/2;
		System.out.println("The median is "+ kthLargest(array, 0, length - 1, kPosition));
	} 
} 




