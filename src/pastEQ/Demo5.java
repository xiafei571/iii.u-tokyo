package pastEQ;

public class Demo5 {
	private static void big(int[] array, int count) {
		if (count == 0)
			return;

		int max = array[0];
		int max_index = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				max_index = i;
			}
		}

		array[max_index] = -1;
		System.out.println(max + "    " + max_index);
		big(array, --count);
	}

	public static void main(String[] args) {
		int[] array = { 3, 9, 0, 5, 6, 2, 1, 4 };
		big(array, 3);
	}

}
