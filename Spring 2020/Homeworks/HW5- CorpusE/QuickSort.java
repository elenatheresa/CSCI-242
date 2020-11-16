import java.util.Arrays;

public class QuickSort {
	private static int[] quickSortArray;

	private static int arraySize;
	
	QuickSort(int newArraySize) {
		arraySize = newArraySize;
		quickSortArray = new int[arraySize];
		insert();
	}

	public void quickSort(int left, int right) {
		if (right - left <= 0)
			return; // Everything is sorted
		else {
			// It doesn't matter what the pivot is, but it must be a value in the array

			int pivot = quickSortArray[right];
			//System.out.println("Value in right " + quickSortArray[right]+ " is made the pivot");
			//System.out.println("left = " + left + " right= " + right+ " pivot= " + pivot + " sent to be partitioned");
			int pivotLocation = partitionArray(left, right, pivot);
			//System.out.println("Value in left " + quickSortArray[left]+ " is made the pivot");
			
			quickSort(left, pivotLocation - 1); // Sorts the left side
			quickSort(pivotLocation + 1, right);

		}

	}
	
	public int partitionArray(int left, int right, int pivot) {

		int leftPos = left - 1;
		int rightPos = right;
		while (true) {
			while (quickSortArray[++leftPos] < pivot);
			//System.out.println(quickSortArray[leftPos] + " in index "
				//	+ leftPos + " is bigger than the pivot value " + pivot);
			while (rightPos > 0 && quickSortArray[--rightPos] > pivot);
			//System.out.println(quickSortArray[rightPos] + " in index "
				//	+ rightPos + " is smaller than the pivot value "+ pivot);
			if (leftPos >= rightPos) {
				//System.out.println("left is >= right so start again");
				break;
			}
			else {
				swapValues(leftPos, rightPos);
				//System.out.println(quickSortArray[leftPos] + " was swapped for "
						//+ quickSortArray[rightPos]);
			}
		}

		swapValues(leftPos, right);
		return leftPos;
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		int temp = quickSortArray[indexOne];
		quickSortArray[indexOne] = quickSortArray[indexTwo];
		quickSortArray[indexTwo] = temp;
	}
	
	public void insert() {
		//for(int i = 1; i < arraySize; i++) {
		//}
			quickSortArray[0] =30;
			quickSortArray[1] =20;
			quickSortArray[2] =50;
			quickSortArray[3] =70;
			quickSortArray[4] =80;
			quickSortArray[5] =60;
			quickSortArray[6] =10;
			quickSortArray[7] =40;
			quickSortArray[8] =90;
			quickSortArray[9] =15;
			quickSortArray[10] =55;
			quickSortArray[11] =25;
			quickSortArray[12] =85;
			quickSortArray[13] =65;
			quickSortArray[14] =35;
	}	
	public static void main(String[] args) {
		//[30, 20, 50, 70, 80, 60, 10, 40, 90, 15, 55, 25, 85, 65, 35]
		QuickSort theSort = new QuickSort(15);
		
		System.out.println("UNSORTED: ");
		System.out.println(Arrays.toString(QuickSort.quickSortArray));
		theSort.quickSort(0, 14);
		System.out.println("SORTED: ");
		System.out.println(Arrays.toString(QuickSort.quickSortArray));

	}
	
}
