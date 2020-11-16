import java.util.Arrays;
public class doubleHash {

	String[] doubleHashArray;
	int arraySize;
	//int itemsInArray = 0;

	public static void main(String[] args) {
		doubleHash function = new doubleHash(11);

		String[] elementsToAdd = {"3", "14", "18", "37","9", "92",
		"21", "86", "11", "42", "10"};
		function.doubleHashing(elementsToAdd, function.doubleHashArray);
	}

	public void doubleHashing(String[] stringsForArray, String[] theArray) {
		int arrayIndex = 0;
		for (int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			//first hashing calculation
			arrayIndex = (2*(Integer.parseInt(newElementVal))+5) % 11;
			//double hash calculation
			int stepDistance = 7 - ((2*(Integer.parseInt(newElementVal))+5) % 7);
			//System.out.println("step distance: " + stepDistance);

			System.out.println("Modulus Index= " + arrayIndex + " for value "
					+ newElementVal);

			while (theArray[arrayIndex] != "-1") {
				arrayIndex += stepDistance;
				arrayIndex %= arraySize;
				System.out.println("Collision Try " + arrayIndex +
						" Instead");
			}
			theArray[arrayIndex] = newElementVal;
		}
	}

	doubleHash(int size) {
		arraySize = size;
		doubleHashArray = new String[size];
		Arrays.fill(doubleHashArray, "-1");
	}

}

