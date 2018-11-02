public class BinaryHeap {
	int[] a; 
	int size; 

	public BinaryHeap() {
		a = new int[10]; 
		size = 0; 
	}

	public void add(int pri) {
		if (size == a.length) {
			grow_array(); 
		}
		a[size] = pri; 
		int index = size; 
		int parent = (index - 1) / 2; 
		while (index > 0 && a[index] < a[parent]) {
			swap(a, index, parent); 
			index = parent; 
			parent = (index - 1) / 2; 
		}
		size++; 
	}

	public int remove() throws IndexOutOfBoundsException{
		if (size == 0) {
			throw new IndexOutOfBoundsException(); 
		}
		int pri = a[0]; 
		a[0] = a[size - 1]; 
		size--; 
		shift_down(0); 
		return pri; 
	}

	private void grow_array() {
		int[] new_array = new int[a.length * 2]; 
		for (int i = 0; i < a.length; i++) {
			new_array[i] = a[i]; 
		}
		a = new_array; 
	}

	private void swap(int[] a, int x, int y) {
		int temp = a[x]; 
		a[x] = a[y]; 
		a[y] = temp; 
	}

	private void shift_down(int parent) {
		int child = parent * 2 + 1; 
		if (child >= size) {
			return; 
		}
		if ((child + 1) < size && a[child + 1] < a[child])
			child ++; 
		if (a[child] < a[parent]) {
			swap(a, child, parent); 
			shift_down(child); 
		}	
	}
}