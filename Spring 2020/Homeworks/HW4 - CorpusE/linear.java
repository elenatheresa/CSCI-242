import java.util.Arrays;
public class linear {

	String[] linearArray;
	int arraySize;
	//int itemsInArray = 0;

	public static void main(String[] args) {
		linear function = new linear(11);

		String[] elementsToAdd = {"3", "14", "18", "37","9", "92",
				"21", "86", "11", "42", "10"};

		function.linearProbing(elementsToAdd, function.linearArray);
		function.remove("3");
		function.remove("14");
		function.remove("18");
		function.remove("37");
		function.remove("9");
		function.remove("92");
		function.remove("21");
		function.remove("86");
		function.remove("11");
		function.remove("42");
		function.remove("10");
	}

	public void linearProbing(String[] stringsForArray, String[] theArray) {
		int arrayIndex = 0;
		for (int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			arrayIndex = (2*(Integer.parseInt(newElementVal))+5) % arraySize;
			System.out.println("Modulus Index= " + arrayIndex + " for value "+ newElementVal);

			// Cycle through the array until we find an empty space
			while (theArray[arrayIndex] != "-1") {
				++arrayIndex;
				// If we get to the end of the array go back to index 0
				arrayIndex %= arraySize;
				System.out.println("Collision Try " + arrayIndex + " Instead");
			}
			theArray[arrayIndex] = newElementVal;
		}
	}

	public void remove(String key) {
		// Find the keys original hash key
		int arrayIndex = (2*(Integer.parseInt(key))+5) % arraySize;

		while (linearArray[arrayIndex] != "-1") {

			if (linearArray[arrayIndex] == key) {

				// Remove the key from the slot
				System.out.println(key + " was found in index "+ arrayIndex);
				linearArray[arrayIndex] = "-1";
				System.out.println(key + " was deleted from index "+ arrayIndex);
			}
			++arrayIndex;
			arrayIndex %= arraySize;
		}
		// Couldn't locate the key
	}
	linear(int size) {
		arraySize = size;
		linearArray = new String[size];
		Arrays.fill(linearArray, "-1");
	}

}



