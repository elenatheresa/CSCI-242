import java.util.LinkedList;

public class chaining {
	public static class chain{
		String key;
		int value;
	}

	public static final int ARR_SIZE = 11;
	private LinkedList<chain>[] chainArray = new LinkedList[ARR_SIZE];

	public void hashTable() {
		for (int i = 0; i < ARR_SIZE; i++) {
			chainArray[i] = null;
		}
	}

	private chain get(String key) {
		if(key == null) 
			return null;
		int index = (2*(key.hashCode())+5) % ARR_SIZE;
		LinkedList<chain> items = chainArray[index];

		if(items == null)
			return null;

		for(chain item : items) {
			if(item.key.equals(key))
				return item;
		}
		return null;
	}

	public void insert(String key, Integer value) {
		int index = (2*(key.hashCode())+5) % ARR_SIZE;
		LinkedList<chain> items = chainArray[index];

		if(items == null) {
			items = new LinkedList<chain>();

			chain item = new chain();
			item.key = key;
			item.value = value;

			items.add(item);

			chainArray[index] = items;
		}
		else {
			for(chain item : items) {
				if(item.key.equals(key)) {
					item.value = value;
					return;
				}
			}

			chain item = new chain();
			item.key = key;
			item.value = value;

			items.add(item);
		}
	}

	public void delete(String key) {
	int index = key.hashCode() % ARR_SIZE;
	LinkedList<chain> items = chainArray[index];

	if(items == null)
		return;

	for(chain item : items) {
		if (item.key.equals(key)) {
			items.remove(item);
			return;
		}
	}
	public static void main(String[] args) {

		insert("3", 3);
		insert("14", 14);
		insert("18", 18);
		insert("37", 37);
		insert("9", 9);
		insert("92", 92);
		insert("21", 21);
		insert("86", 86);
		insert("11", 11);
		insert("42", 42);
		insert("10", 10);
	}

}


