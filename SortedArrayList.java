import java.util.Arrays;


public class SortedArrayList<T extends Comparable<T>> implements SortedList<T> {

	//ArrayList j;
	public T[] sortedAL;
	private int size;


	public SortedArrayList(int size) {

		this.size = 0;
		sortedAL = (T[]) new Comparable[this.size + 1];

		//a = (T[]) new Object[16];
		//size = 0;

	}

	@Override
	public int size() {
		return size;
	}


	@Override
	public String toString() {
		return "SortedArrayList{" + "sortedAL="+ Arrays.toString(sortedAL)
				+ ", size=" + size + "}";
	}

	@Override
	public boolean add(T item) {
		int a = sortedAL.length;
		if (size == a) {
			grow_array();
		}
		if (size == 0) {
			sortedAL[size++] = item;
			return true;
		}
		int size_of_i = size-1;
		size++;
		while (sortedAL[size_of_i].compareTo(item) > 0) {
			sortedAL[size_of_i+1] = sortedAL[size_of_i];
			if (size_of_i > 0) {
				size_of_i--;
			} else {
				sortedAL[size_of_i] = item;
				return true;
			}
		}
		sortedAL[size_of_i+1] = item;
		return true;
	}




	@Override
	public T remove(int item) {
		if (item < 0 || item >= size)
			System.out.println("INVALID POSITION ");
		T position = sortedAL[item];
		for (int i = item; i < size - 1; i++){
			sortedAL[i] = sortedAL[i + 1];
		}
		size-=1;
		return position;
	}

	private void grow_array() {
		int length = sortedAL.length;
		T[] new_arr = (T[]) new Comparable[this.size+1];
		for (int i = 0; i < sortedAL.length; i++) {
			new_arr[i] = sortedAL[i];
		}
		sortedAL = new_arr;
	}

	@Override
	public T get(int item) throws Exception {
		//binary search
		if (item<0 || item >= size) {
			throw new Exception("Invalid position");
		}
		return sortedAL[item];
	}

	public static void main(String[] args) throws Exception{
		SortedArrayList r = new SortedArrayList(10);
		r.add(44);
		r.add(12);
		r.add(10);
		r.add(8);
		r.add(2);
		r.add(5);
		r.add(3);
		r.add(2);
		r.add(9);
		r.add(4);
		r.add(1);
		for (int i = 0; i < r.size; i++) {
			System.out.println(r.get(i) + " ");
		}


	}






	
}