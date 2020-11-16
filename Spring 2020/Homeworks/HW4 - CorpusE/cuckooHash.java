import java.util.Arrays;
public class cuckooHash {

	public class linear {

		String[] cuckooArray1;
		String[] cuckooArray2;
		int arraySize;
		//int itemsInArray = 0;

		public void main(String[] args) {
			linear function = new linear(11);

			String[] elementsToAdd = {"3", "14", "18", "37","9", "92",
			"21", "86", "11", "42", "10"};

			function.cuckooHashing(elementsToAdd, function.cuckooArray1, function.cuckooArray2);
		}

		public void cuckooHashing(String[] stringsForArray, String[] theArray, String[] theArray2) {
			int arrayIndex = 0;
			for (int n = 0; n < stringsForArray.length; n++) {
				String newElementVal = stringsForArray[n];
				arrayIndex = (2*(Integer.parseInt(newElementVal))+5) % arraySize;
				System.out.println("Modulus Index = " + arrayIndex + " for value "+ newElementVal);

				// Cycle through the array until we find an empty space
				while (theArray[arrayIndex] != "-1") {
					arrayIndex = (3*(Integer.parseInt(newElementVal))+1) % arraySize;
					theArray2[arrayIndex] = newElementVal;
				}
				theArray[arrayIndex] = newElementVal;
			}
		}

		linear(int size) {

			arraySize = size;

			cuckooArray1 = new String[size];
			cuckooArray2 = new String[size];
			Arrays.fill(cuckooArray1, "-1");
			Arrays.fill(cuckooArray2, "-1");

		}
	}
}
